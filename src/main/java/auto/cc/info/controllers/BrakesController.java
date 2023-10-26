package auto.cc.info.controllers;

import auto.cc.info.commands.BrakesCommand;
import auto.cc.info.service.BrakesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/brakes")
@Slf4j
public class BrakesController {
    private BrakesService brakesService;
    @Autowired
    public void setBrakesService(BrakesService brakesService) {
        this.brakesService = brakesService;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public BrakesCommand addNewBrakes(@RequestBody BrakesCommand brakesCommand){
        Optional<BrakesCommand> brakesCommandOptional = Optional.ofNullable(brakesService.addBrakes(brakesCommand));
        if(!brakesCommandOptional.isPresent()){
            log.error("Your new brakes not added failed process !!!");
            return null;
        }
        else {
            return brakesCommandOptional.get();
        }
    }
}
