package auto.cc.info.controllers;

import auto.cc.info.dto.otherComponents.SafetyAndSecurityCommand;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.SafetyAndSecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("/api/safety")
@Slf4j
public class SafetyAndSecurityController {
    private SafetyAndSecurityService safetyAndSecurityService;
    @Autowired
    public void setSafetyAndSecurityService(SafetyAndSecurityService safetyAndSecurityService) {
        this.safetyAndSecurityService = safetyAndSecurityService;
    }


    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
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

    @QueryMapping(name = "findBySecurityId")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public SafetyAndSecurityCommand findBySecurityId(@Argument Long id) {
        SafetyAndSecurityCommand safetyAndSecurityCommand = safetyAndSecurityService.findBySSId(id);
        return safetyAndSecurityCommand;
    }
}
