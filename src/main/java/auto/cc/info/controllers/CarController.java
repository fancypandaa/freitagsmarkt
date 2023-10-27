package auto.cc.info.controllers;

import auto.cc.info.commands.CarCommand;
import auto.cc.info.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/car")
@Slf4j
public class CarController {
    private CarService carService;
    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
    @QueryMapping("listAllCars")
    public Page<CarCommand> listAllCars(@Argument int page, @Argument int size){
        Page<CarCommand> carCommands = carService.listCars(page,size);
        return carCommands;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
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
}
