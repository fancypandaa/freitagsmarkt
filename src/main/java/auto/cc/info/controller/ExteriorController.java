package auto.cc.info.controllers;

import auto.cc.info.dto.otherComponents.ExteriorDTO;
import auto.cc.info.dto.otherComponents.ExteriorEquipmentCommand;
import auto.cc.info.dto.custom.IExteriorCustom;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.ExteriorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exterior")
@Slf4j
public class ExteriorController {
    private ExteriorService exteriorService;
    @Autowired
    public void setExteriorService(ExteriorService exteriorService) {
        this.exteriorService = exteriorService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public ExteriorDTO addNewExterior(@RequestBody ExteriorDTO exteriorCommand){
        Optional<ExteriorDTO> exteriorCommandOptional = Optional.ofNullable(exteriorService.createExterior(exteriorCommand));
        if(!exteriorCommandOptional.isPresent()){
            log.error("failed process !!!");
            return null;
        }
        else {
            return exteriorCommandOptional.get();
        }
    }
    @RequestMapping(value = "/equip",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
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
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public ExteriorDTO findExteriorById(@Argument Long id) {
        ExteriorDTO exteriorCommand = exteriorService.findByExteriorId(id);
        return exteriorCommand;
    }

    @QueryMapping(name = "getChassisTypesByGroups")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public List<IExteriorCustom> getChassisTypesByGroups(){
        List<IExteriorCustom> exteriorCustomList = exteriorService.getChassisTypesByGroups();
        return exteriorCustomList;
    }
}
