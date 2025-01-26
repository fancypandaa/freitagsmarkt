package auto.cc.info.controllers;

import auto.cc.info.dto.carSpecs.BrakesDTO;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.BrakesService;
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
@RequestMapping("/api/brakes")
@Slf4j
public class BrakesController {
    private BrakesService brakesService;
    @Autowired
    public void setBrakesService(BrakesService brakesService) {
        this.brakesService = brakesService;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public BrakesDTO addNewBrakes(@RequestBody BrakesDTO brakesCommand){
        Optional<BrakesDTO> brakesCommandOptional = Optional.ofNullable(brakesService.addBrakes(brakesCommand));
        if(!brakesCommandOptional.isPresent()){
            log.error("Your new brakes not added failed process !!!");
            return null;
        }
        else {
            return brakesCommandOptional.get();
        }
    }
    @QueryMapping(name = "findBrakesById")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public BrakesDTO findAdById(@Argument Long id) {
        BrakesDTO brakes = brakesService.findBrakesById(id);
        return brakes;
    }
}
