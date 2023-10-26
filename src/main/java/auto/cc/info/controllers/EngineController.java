package auto.cc.info.controllers;

import auto.cc.info.commands.EngineCommand;
import auto.cc.info.service.EngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @RequestMapping(value = "/engine_list", method= RequestMethod.GET, produces = "application/json")
    public Page<EngineCommand> listAllEngine(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "10") int size){
        Page<EngineCommand> engineCommandPage = engineService.listEngines(page,size);
        return engineCommandPage;
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
}
