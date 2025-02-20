package auto.freitagsmarkt.service.car;


import auto.freitagsmarkt.dto.car.CarDTO;

import java.util.List;

public interface CarService {
    CarDTO addNewCar(CarDTO carDTO);
    List<CarDTO> listCars(int page, int size);
    CarDTO findCarById(Long carId);
    CarDTO updateCarById(Long carId,CarDTO carDTO);
    Boolean removeCarById(Long Id);
}
