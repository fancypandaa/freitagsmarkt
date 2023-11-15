package auto.cc.info.controllers;

import auto.cc.info.commands.TransmissionCommand;
import auto.cc.info.commands.custom.IFuelCustom;
import auto.cc.info.commands.custom.ITransmissionCustom;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.TransmissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transmissions")
@Slf4j
public class TransmissionsController {
    private TransmissionService transmissionService;

    @Autowired
    public void setTransmissionService(TransmissionService transmissionService) {
        this.transmissionService = transmissionService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public TransmissionCommand addTransmissionInfo(@RequestBody TransmissionCommand transmissionCommand){
        Optional<TransmissionCommand> transmissionCommand1 = Optional.ofNullable(transmissionService.createNewTransmissionsItems(transmissionCommand));
        if(!transmissionCommand1.isPresent()){
            log.error("Your new fuel not added failed process !!!");
            return null;
        }
        else {
            return transmissionCommand1.get();
        }
    }

    @QueryMapping(name = "getTransmissionTypesByGroups")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public List<ITransmissionCustom> getTransmissionTypesByGroups(){
        List<ITransmissionCustom> transmissionCustoms = transmissionService.getTransmissionTypesByGroups();
        return transmissionCustoms;
    }
}
