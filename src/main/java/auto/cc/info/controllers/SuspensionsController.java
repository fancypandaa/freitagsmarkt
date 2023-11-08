package auto.cc.info.controllers;

import auto.cc.info.commands.SuspensionsCommand;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.SuspensionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("/api/suspensions")
@Slf4j
public class SuspensionsController {
    private SuspensionsService suspensionsService;

    @Autowired
    public void setSuspensionsService(SuspensionsService suspensionsService) {
        this.suspensionsService = suspensionsService;
    }


    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
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
