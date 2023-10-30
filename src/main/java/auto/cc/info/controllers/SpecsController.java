package auto.cc.info.controllers;

import auto.cc.info.commands.BrakesCommand;
import auto.cc.info.commands.SpecsCommand;
import auto.cc.info.service.SpecsService;
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
@RequestMapping("/specs")
@Slf4j
public class SpecsController {
    private SpecsService specsService;
    @Autowired
    public SpecsController(SpecsService specsService) {
        this.specsService = specsService;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public SpecsCommand addNewSpecs(@RequestBody SpecsCommand specsCommand){
        Optional<SpecsCommand> specsCommandOptional = Optional.ofNullable(specsService.createNewSpecs(specsCommand));
        if(!specsCommandOptional.isPresent()){
            log.error("Your new s not specs  failed process !!!");
            return null;
        }
        else {
            return specsCommandOptional.get();
        }
    }

    @QueryMapping(name = "findBySpecsId")
    public SpecsCommand findBySpecsId(@Argument Long id) {
        SpecsCommand specsCommand = specsService.findSpecsById(id);
        return specsCommand;
    }
}
