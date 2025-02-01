package auto.cc.info.controller;

import auto.cc.info.dto.car.otherComponents.InteriorDTO;
import auto.cc.info.dto.otherComponents.InteriorEquipmentsCommand;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.InteriorService;
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
@RequestMapping("/api/interior")
@Slf4j
public class InteriorController {
    private InteriorService interiorService;
    @Autowired

    public void setInteriorService(InteriorService interiorService) {
        this.interiorService = interiorService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public InteriorDTO addNewInterior(@RequestBody InteriorDTO interiorCommand){
        Optional<InteriorDTO> interiorCommandOptional = Optional.ofNullable(interiorService.createInterior(interiorCommand));
        if(!interiorCommandOptional.isPresent()){
            log.error("failed process !!!");
            return null;
        }
        else {
            return interiorCommandOptional.get();
        }
    }
    @RequestMapping(value = "/equip",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public InteriorEquipmentsCommand addNewInteriorEquip(@RequestBody InteriorEquipmentsCommand interiorEquipmentsCommand){
        Optional<InteriorEquipmentsCommand> interiorEquipmentsCommandOptional = Optional.ofNullable(interiorService.createInteriorEquip(interiorEquipmentsCommand));
        if(!interiorEquipmentsCommandOptional.isPresent()){
            log.error("failed process !!!");
            return null;
        }
        else {
            return interiorEquipmentsCommandOptional.get();
        }
    }
    @QueryMapping(name = "findInteriorId")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public InteriorDTO findInteriorId(@Argument Long id) {
        InteriorDTO interiorCommand = interiorService.findInteriorById(id);
        return interiorCommand;
    }
}
