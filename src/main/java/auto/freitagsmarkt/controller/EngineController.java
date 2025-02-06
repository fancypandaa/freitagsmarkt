package auto.freitagsmarkt.controller;

import auto.freitagsmarkt.dto.car.specs.EngineDTO;
import auto.freitagsmarkt.dto.carSpecs.EngineCommand;
import auto.freitagsmarkt.domain.user.Constants;
import auto.freitagsmarkt.service.EngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(EngineController.EngineURI)
public class EngineController {
    public static final String EngineURI = "/api/engine";
    private EngineService engineService;

    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }
    @GetMapping("/list-engines")
    public ResponseEntity<List<EngineDTO>> listAllEngine(
            @RequestParam(defaultValue = "0")  int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(engineService.listEngines(page, size));
    }
    @GetMapping("/{engineId}")
    public ResponseEntity<EngineDTO> findEngineById(@PathVariable Long engineId){
        return ResponseEntity.ok(engineService.findEngineById(engineId));
    }
    public ResponseEntity<EngineDTO> addNewEngine(@RequestBody EngineDTO engineDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(engineService.addNewEngineDetails(engineDTO));
    }
    public void deleteEngineById(@PathVariable Long engineId){
        engineService.removeEngineById(engineId);
    }
}
