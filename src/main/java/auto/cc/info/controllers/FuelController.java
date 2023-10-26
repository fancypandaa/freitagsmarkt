package auto.cc.info.controllers;

import auto.cc.info.commands.FuelCommand;
import auto.cc.info.service.FuelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/fuel")
@Slf4j
public class FuelController {
    private FuelService fuelService;
    @Autowired
    public void setFuelService(FuelService fuelService) {
        this.fuelService = fuelService;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public FuelCommand addFuelInfo(@RequestBody FuelCommand fuelCommand){
        Optional<FuelCommand> fuelCommandOptional = Optional.ofNullable(fuelService.addFuelInfo(fuelCommand));
        if(!fuelCommandOptional.isPresent()){
            log.error("Your new fuel not added failed process !!!");
            return null;
        }
        else {
            return fuelCommandOptional.get();
        }
    }
}
