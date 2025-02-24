package auto.freitagsmarkt.controller.specs;

import auto.freitagsmarkt.dto.specs.InteriorDTO;
import auto.freitagsmarkt.service.specs.InteriorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(InteriorController.INTERIOR_URI)
public class InteriorController {
    public static final String INTERIOR_URI ="/api/interior";
    private InteriorService interiorService;

    public InteriorController(InteriorService interiorService) {
        this.interiorService = interiorService;
    }

    @PostMapping
    public ResponseEntity<InteriorDTO> addNewInterior(@RequestBody InteriorDTO interiorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(interiorService.createInterior(interiorDTO));
    }
    @GetMapping("/{interiorId}")
    public ResponseEntity<InteriorDTO> findInteriorId(@PathVariable Long interiorId) {
        return ResponseEntity.ok(interiorService.findInteriorById(interiorId));
    }
}
