package auto.cc.info.service;

import auto.cc.info.commands.CarCommand;
import auto.cc.info.domain.Car;
import org.springframework.data.domain.Page;

public interface CarService {
    CarCommand addNewCar(CarCommand carCommand);
    Page<CarCommand> listCars(int page,int size);
    CarCommand findCarById(Long carId);
    CarCommand updateCarById(Long carId,CarCommand newCarCommand);
    void removeCarById(Long Id);
}
