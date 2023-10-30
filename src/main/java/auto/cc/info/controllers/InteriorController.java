package auto.cc.info.controllers;

import auto.cc.info.commands.ExteriorCommand;
import auto.cc.info.commands.InteriorCommand;
import auto.cc.info.commands.InteriorEquipmentsCommand;
import auto.cc.info.service.InteriorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/interior")
@Slf4j
public class InteriorController {
    private InteriorService interiorService;
    @Autowired

    public void setInteriorService(InteriorService interiorService) {
        this.interiorService = interiorService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public InteriorCommand addNewInterior(@RequestBody InteriorCommand interiorCommand){
        Optional<InteriorCommand> interiorCommandOptional = Optional.ofNullable(interiorService.createInterior(interiorCommand));
        if(!interiorCommandOptional.isPresent()){
            log.error("failed process !!!");
            return null;
        }
        else {
            return interiorCommandOptional.get();
        }
    }
    @RequestMapping(value = "/equip",method = RequestMethod.POST,produces = "application/json")
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
    public InteriorCommand findInteriorId(@Argument Long id) {
        InteriorCommand interiorCommand = interiorService.findInteriorById(id);
        return interiorCommand;
    }
}
