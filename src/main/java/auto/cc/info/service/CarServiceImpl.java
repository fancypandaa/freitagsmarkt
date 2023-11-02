package auto.cc.info.service;

import auto.cc.info.commands.CarCommand;
import auto.cc.info.converters.CarCommandToCar;
import auto.cc.info.converters.CarToCarCommand;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.CarBrand;
import auto.cc.info.repository.CarBrandRepository;
import auto.cc.info.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
@Slf4j
@Service
public class CarServiceImpl implements CarService{
    private final CarCommandToCar carCommandToCar;
    private final CarToCarCommand carToCarCommand;
    private final CarRepository carRepository;
    private final CarBrandRepository carBrandRepository;
    public CarServiceImpl(CarCommandToCar carCommandToCar, CarToCarCommand carToCarCommand, CarRepository carRepository, CarBrandRepository carBrandRepository) {
        this.carCommandToCar = carCommandToCar;
        this.carToCarCommand = carToCarCommand;
        this.carRepository = carRepository;
        this.carBrandRepository = carBrandRepository;
    }

    @Override
    @Transactional
    public CarCommand addNewCar(CarCommand carCommand) {
        Optional<CarBrand> carBrandOptional = carBrandRepository.findById(carCommand.getCarBrandId());
        if(!carBrandOptional.isPresent()){
            return new CarCommand();
        }
        CarBrand carBrand = carBrandOptional.get();
        Car car = carCommandToCar.convert(carCommand);
        car.setCarBrand(carBrand);
        carBrand.setCars(car);
        carRepository.save(car);
        return carToCarCommand.convert(car);

    }

    @Override
    public Page<CarCommand> listCars(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        List<CarCommand> carCommandList = carRepository.findAll(paging).stream()
                .map(car -> {
                    CarCommand carCommand = carToCarCommand.convert(car);
                    return carCommand;
                }).collect(Collectors.toList());
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), carCommandList.size());
        List<CarCommand> pageContent = carCommandList.subList(start,end);
        return new PageImpl<>(pageContent, paging, carCommandList.size());
    }

    @Override
    @Transactional
    @Cacheable(value = "Car",key="#carId")
    public CarCommand findCarById(Long carId) {
        Optional<Car> carOptional = carRepository.findById(carId);
        if(!carOptional.isPresent()) return null;
        return carToCarCommand.convert(carOptional.get());
    }


}
