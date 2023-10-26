package auto.cc.info.service;

import auto.cc.info.commands.CarCommand;
import org.springframework.data.domain.Page;

public interface CarService {
    CarCommand addNewCar(CarCommand carCommand);
    Page<CarCommand> listCars(int page,int size);
}
