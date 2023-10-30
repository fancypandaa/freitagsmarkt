package auto.cc.info.controllers;

import auto.cc.info.commands.FuelCommand;
import auto.cc.info.commands.SuspensionsCommand;
import auto.cc.info.service.FuelService;
import auto.cc.info.service.SuspensionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/suspensions")
@Slf4j
public class SuspensionsController {
    private SuspensionsService suspensionsService;

    @Autowired
    public void setSuspensionsService(SuspensionsService suspensionsService) {
        this.suspensionsService = suspensionsService;
    }


    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public SuspensionsCommand addSuspensionsInfo(@RequestBody SuspensionsCommand suspensionsCommand){
        Optional<SuspensionsCommand> suspensionsCommandOptional = Optional.ofNullable(suspensionsService.createNewSuspensionsItems(suspensionsCommand));
        if(!suspensionsCommandOptional.isPresent()){
            log.error("Your new fuel not added failed process !!!");
            return null;
        }
        else {
            return suspensionsCommandOptional.get();
        }
    }
}
