package auto.freitagsmarkt.service.impl.car;

import auto.freitagsmarkt.domain.car.Car;
import auto.freitagsmarkt.dto.car.CarDTO;
import auto.freitagsmarkt.mapper.car.CarMapper;
import auto.freitagsmarkt.repository.CarRepository;
import auto.freitagsmarkt.service.car.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private CarMapper carMapper;
    private CarRepository carRepository;

    public CarServiceImpl(CarMapper carMapper, CarRepository carRepository) {
        this.carMapper = carMapper;
        this.carRepository = carRepository;
    }

    @Override
    public CarDTO addNewCar(CarDTO carDTO) {
        return Optional.ofNullable(carDTO)
                .map(carMapper::toCar)
                .map(carRepository::save)
                .map(carMapper::toCarDTO)
                .orElseThrow(() ->new RuntimeException("Car not created"));
    }

    @Override
    public List<CarDTO> listCars(int page, int size) {
        Page<Car> carList = carRepository.findAll(PageRequest.of(page,size));
        if(carList.getTotalElements() <= 0){
            return Collections.EMPTY_LIST;
        }
        return carMapper.toCarListDTO(carList.getContent());
    }

    @Override
    public CarDTO findCarById(Long carId) {
        return carRepository.findById(carId)
                .map(carMapper::toCarDTO)
                .orElseThrow(() -> new RuntimeException("Car Not Found"));
    }

    @Override
    public CarDTO updateCarById(Long carId, CarDTO carDTO) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car Not updated"));
        carMapper.updateCarFromCarDTO(carDTO,car);
        return carMapper.toCarDTO(carRepository.save(car));
    }

    @Override
    public Boolean removeCarById(Long carId) {
        if(carRepository.existsById(carId)){
            carRepository.deleteById(carId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
