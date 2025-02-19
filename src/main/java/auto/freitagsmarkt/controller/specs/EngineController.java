package auto.freitagsmarkt.controller.specs;

import auto.freitagsmarkt.dto.specs.EngineDTO;
import auto.freitagsmarkt.service.specs.EngineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(EngineController.EngineURI)
public class EngineController {
    public static final String EngineURI = "/api/engine";
    private EngineService engineService;

    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }
    @GetMapping("/all-engines")
    public ResponseEntity<List<EngineDTO>> listAllEngine(
            @RequestParam(defaultValue = "0")  int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(engineService.listEngines(page, size));
    }
    @GetMapping("/{engineId}")
    public ResponseEntity<EngineDTO> findEngineById(@PathVariable Long engineId){
        return ResponseEntity.ok(engineService.findEngineById(engineId));
    }
    @PostMapping
    public ResponseEntity<EngineDTO> addNewEngine(@RequestBody EngineDTO engineDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(engineService.addNewEngineDetails(engineDTO));
    }
    @DeleteMapping("/{engineId}")
    public ResponseEntity<String> deleteEngineById(@PathVariable Long engineId){
        return (engineService.removeEngineById(engineId))?
                ResponseEntity.ok("Engine deleted successfully!!"):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Engine with the given ID does not exist");
    }
}
