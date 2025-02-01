package auto.cc.info.service;

import auto.cc.info.dto.carSpecs.CarCommand;
import auto.cc.info.dto.custom.ICarCustom;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{

    @Override
    public CarCommand addNewCar(CarCommand carCommand) {
        return null;
    }

    @Override
    public Page<CarCommand> listCars(int page, int size) {
        return null;
    }

    @Override
    public CarCommand findCarById(Long carId) {
        return null;
    }

    @Override
    public CarCommand updateCarById(Long carId, CarCommand newCarCommand) {
        return null;
    }

    @Override
    public List<ICarCustom> getCarCityTypesByGroups() {
        return null;
    }

    @Override
    public void removeCarById(Long Id) {

    }
}
