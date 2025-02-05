package auto.freitagsmarkt.service;


import auto.freitagsmarkt.dto.car.CarDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarService {
    CarDTO addNewCar(CarDTO carDTO);
    List<CarDTO> listCars(int page, int size);
    CarDTO findCarById(Long carId);
    CarDTO updateCarById(Long carId,CarDTO carDTO);
    void removeCarById(Long Id);
}
