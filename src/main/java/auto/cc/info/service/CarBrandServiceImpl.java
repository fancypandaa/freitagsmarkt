package auto.cc.info.service;

import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.converters.CarBrandCommandToCarBrand;
import auto.cc.info.converters.CarBrandToCarBrandCommand;
import auto.cc.info.domain.CarBrand;
import auto.cc.info.repository.CarBrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
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
    @Transactional
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

    @Override
    @Transactional
    @Cacheable(value = "CarBrand",key="#carBrandId")
    public CarBrandCommand findCarBrandById(Long carBrandId) {
        Optional<CarBrand> carBrand = carBrandRepository.findById(carBrandId);
        if(!carBrand.isPresent()) return null;
        return carBrandToCarBrandCommand.convert(carBrand.get());
    }

    @Override
    @Transactional
    @Cacheable(value = "carBrandList")
    public Page<CarBrandCommand> findByProductionYearsAndSeries(Integer page,Integer size,Optional<String> series,Optional<Integer> productionYear) {
        Pageable paging = PageRequest.of(page, size);
        List<CarBrand> carBrandList = new ArrayList<>();
        if(series.isPresent() && productionYear.isPresent()){
            carBrandList= carBrandRepository.findByProductionYearsAndSeries(paging,series.get(),productionYear.get()).toList();
        } else if (!series.isPresent() && productionYear.isPresent()) {
            carBrandList= carBrandRepository.findByProductionYears(paging,productionYear.get()).toList();
        } else if (!productionYear.isPresent() && series.isPresent()) {
            carBrandList= carBrandRepository.findBySeries(paging,series.get()).toList();
        } else {
            carBrandList= carBrandRepository.findAll();
        }
        List<CarBrandCommand> carBrandCommandList =  carBrandList.stream().map(carBrand -> {
            CarBrandCommand carBrandCommand =carBrandToCarBrandCommand.convert(carBrand);
            return carBrandCommand;
        }).collect(Collectors.toList());
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), carBrandList.size());
        List<CarBrandCommand> pageContent = carBrandCommandList.subList(start,end);
        return new PageImpl<>(pageContent, paging, carBrandCommandList.size());
    }
}
