package auto.cc.info.service;

import auto.cc.info.commands.CarCommand;
import auto.cc.info.commands.custom.ICarCustom;
import org.springframework.data.domain.Page;
import java.util.List;

public interface CarService {
    CarCommand addNewCar(CarCommand carCommand);
    Page<CarCommand> listCars(int page,int size);
    CarCommand findCarById(Long carId);
    CarCommand updateCarById(Long carId,CarCommand newCarCommand);
    List<ICarCustom> getCarCityTypesByGroups();
    void removeCarById(Long Id);
}
