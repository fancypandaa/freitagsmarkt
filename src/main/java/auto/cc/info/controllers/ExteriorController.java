package auto.cc.info.controllers;

import auto.cc.info.commands.BrakesCommand;
import auto.cc.info.commands.ExteriorCommand;
import auto.cc.info.commands.ExteriorEquipmentCommand;
import auto.cc.info.commands.custom.IExteriorCustom;
import auto.cc.info.commands.custom.IFuelCustom;
import auto.cc.info.service.ExteriorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exterior")
@Slf4j
public class ExteriorController {
    private ExteriorService exteriorService;
    @Autowired
    public void setExteriorService(ExteriorService exteriorService) {
        this.exteriorService = exteriorService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public ExteriorCommand addNewExterior(@RequestBody ExteriorCommand exteriorCommand){
        Optional<ExteriorCommand> exteriorCommandOptional = Optional.ofNullable(exteriorService.createExterior(exteriorCommand));
        if(!exteriorCommandOptional.isPresent()){
            log.error("failed process !!!");
            return null;
        }
        else {
            return exteriorCommandOptional.get();
        }
    }
    @RequestMapping(value = "/equip",method = RequestMethod.POST,produces = "application/json")
    public ExteriorEquipmentCommand addNewExteriorEquip(@RequestBody ExteriorEquipmentCommand exteriorEquipmentCommand){
        Optional<ExteriorEquipmentCommand> exteriorEquipmentCommandOptional = Optional.ofNullable(exteriorService.createExteriorEquip(exteriorEquipmentCommand));
        if(!exteriorEquipmentCommandOptional.isPresent()){
            log.error("failed process !!!");
            return null;
        }
        else {
            return exteriorEquipmentCommandOptional.get();
        }
    }
    @QueryMapping(name = "findExteriorById")
    public ExteriorCommand findExteriorById(@Argument Long id) {
        ExteriorCommand exteriorCommand = exteriorService.findByExteriorId(id);
        return exteriorCommand;
    }

    @QueryMapping(name = "getChassisTypesByGroups")
    public List<IExteriorCustom> getChassisTypesByGroups(){
        List<IExteriorCustom> exteriorCustomList = exteriorService.getChassisTypesByGroups();
        return exteriorCustomList;
    }
}
