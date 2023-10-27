package auto.cc.info.controllers;

import auto.cc.info.commands.ExteriorCommand;
import auto.cc.info.commands.ExteriorEquipmentCommand;
import auto.cc.info.service.ExteriorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}