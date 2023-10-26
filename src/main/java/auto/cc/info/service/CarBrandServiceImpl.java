package auto.cc.info.service;

import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.converters.CarBrandCommandToCarBrand;
import auto.cc.info.converters.CarBrandToCarBrandCommand;
import auto.cc.info.domain.CarBrand;
import auto.cc.info.repository.CarBrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CarBrandServiceImpl implements CarBrandService{
    private final CarBrandRepository carBrandRepository;
    private final CarBrandToCarBrandCommand carBrandToCarBrandCommand;
    private final CarBrandCommandToCarBrand carBrandCommandToCarBrand;

    public CarBrandServiceImpl(CarBrandRepository carBrandRepository, CarBrandToCarBrandCommand carBrandToCarBrandCommand, CarBrandCommandToCarBrand carBrandCommandToCarBrand) {
        this.carBrandRepository = carBrandRepository;
        this.carBrandToCarBrandCommand = carBrandToCarBrandCommand;
        this.carBrandCommandToCarBrand = carBrandCommandToCarBrand;
    }

    @Override
    public Page<CarBrandCommand> listCarBrands(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        List<CarBrandCommand> carBrandList = carBrandRepository.findAll(paging).stream()
                .map(carBrand -> {
                    CarBrandCommand carBrandCommand = carBrandToCarBrandCommand.convert(carBrand);
                    return carBrandCommand;
                }).collect(Collectors.toList());
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), carBrandList.size());
        List<CarBrandCommand> pageContent = carBrandList.subList(start,end);
        return new PageImpl<>(pageContent, paging, carBrandList.size());
    }

    @Override
    @Transactional
    public CarBrandCommand addNewCarBrand(CarBrandCommand carBrandCommand) {
        Optional<CarBrand> carBrandOptional = Optional.ofNullable(carBrandRepository.findByName(carBrandCommand.getName()));
        if(carBrandOptional.isPresent()) {
            return new CarBrandCommand();
        }
        CarBrand carBrand = carBrandCommandToCarBrand.convert(carBrandCommand);
        carBrandRepository.save(carBrand);
        return carBrandCommand;
    }
}
