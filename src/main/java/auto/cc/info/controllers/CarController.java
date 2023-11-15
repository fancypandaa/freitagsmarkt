package auto.cc.info.controllers;

import auto.cc.info.commands.BrakesCommand;
import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.commands.CarCommand;
import auto.cc.info.commands.custom.ICarCustom;
import auto.cc.info.commands.custom.ITransmissionCustom;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/car")
@Slf4j
public class CarController {
    private CarService carService;
    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public CarCommand addNewCar(@RequestBody CarCommand carCommand){
        Optional<CarCommand> carCommandOptional = Optional.ofNullable(carService.addNewCar(carCommand));
        if(!carCommandOptional.isPresent()){
            log.error("Your new car not added failed process !!!");
            return null;
        }
        else {
            return carCommandOptional.get();
        }
    }
    @RequestMapping(value = "/{carId}",method = RequestMethod.PATCH,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public CarCommand updateCar(@PathVariable Long carId, @RequestBody CarCommand carCommand){
        CarCommand carCommand1 = carService.updateCarById(carId,carCommand);
        return carCommand1;
    }
    @RequestMapping(value = "{carId}",method = RequestMethod.DELETE,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public void deleteCarById(@PathVariable Long carId){
        carService.removeCarById(carId);
    }
    @QueryMapping("listAllCars")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public Page<CarCommand> listAllCars(@Argument int page, @Argument int size){
        Page<CarCommand> carCommands = carService.listCars(page,size);
        return carCommands;
    }
    @QueryMapping(name = "findCarById")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public CarCommand findCarById(@Argument Long id) {
        CarCommand car = carService.findCarById(id);
        return car;
    }

    @QueryMapping(name = "getCarCityTypesByGroups")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public List<ICarCustom> getCarCityTypesByGroups(){
        List<ICarCustom> carCustoms = carService.getCarCityTypesByGroups();
        return carCustoms;
    }
}
