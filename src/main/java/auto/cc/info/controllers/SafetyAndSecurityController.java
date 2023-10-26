package auto.cc.info.controllers;

import auto.cc.info.commands.SafetyAndSecurityCommand;
import auto.cc.info.service.SafetyAndSecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/safety")
@Slf4j
public class SafetyAndSecurityController {
    private SafetyAndSecurityService safetyAndSecurityService;
    @Autowired
    public void setSafetyAndSecurityService(SafetyAndSecurityService safetyAndSecurityService) {
        this.safetyAndSecurityService = safetyAndSecurityService;
    }


    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public SafetyAndSecurityCommand addNewCarFeatures(@RequestBody SafetyAndSecurityCommand safetyAndSecurityCommand){
        Optional<SafetyAndSecurityCommand> safetyAndSecurityCommandOptional = Optional.ofNullable(safetyAndSecurityService.addNewSafetyAndSecurity(safetyAndSecurityCommand));
        if(!safetyAndSecurityCommandOptional.isPresent()){
            log.error("Your new brand not added failed process !!!");
            return null;
        }
        else {
            return safetyAndSecurityCommandOptional.get();
        }
    }
}
