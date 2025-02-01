package auto.cc.info.controller;

import auto.cc.info.dto.carSpecs.EngineCommand;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.EngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("/api/engine")
@Slf4j
public class EngineController {
    private EngineService engineService;
    @Autowired
    public void setEngineService(EngineService engineService) {
        this.engineService = engineService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public EngineCommand addNewEngine(@RequestBody EngineCommand engineCommand){
        Optional<EngineCommand> engineCommandOptional = Optional.ofNullable(engineService.addNewEngineDetails(engineCommand));
        if(!engineCommandOptional.isPresent()){
            log.error("Your new engine not added failed process !!!");
            return null;
        }
        else {
            return engineCommandOptional.get();
        }
    }
    @RequestMapping(value = "{engineId}",method = RequestMethod.DELETE,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public void deleteEngineById(@PathVariable Long engineId){
        engineService.removeEngineById(engineId);
    }
    @QueryMapping("listAllEngine")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public Page<EngineCommand> listAllEngine(@Argument int page, @Argument int size){
        Page<EngineCommand> engineCommandPage = engineService.listEngines(page,size);
        return engineCommandPage;
    }
}
