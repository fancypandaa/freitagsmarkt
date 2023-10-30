package auto.cc.info.controllers;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.commands.EngineCommand;
import auto.cc.info.service.EngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/engine")
@Slf4j
public class EngineController {
    private EngineService engineService;
    @Autowired
    public void setEngineService(EngineService engineService) {
        this.engineService = engineService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
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
    @QueryMapping("listAllEngine")
    public Page<EngineCommand> listAllEngine(@Argument int page, @Argument int size){
        Page<EngineCommand> engineCommandPage = engineService.listEngines(page,size);
        return engineCommandPage;
    }
}
