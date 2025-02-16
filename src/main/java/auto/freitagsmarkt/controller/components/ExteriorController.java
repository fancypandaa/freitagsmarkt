package auto.freitagsmarkt.controller.components;

import auto.freitagsmarkt.dto.components.ExteriorDTO;
import auto.freitagsmarkt.service.components.ExteriorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(ExteriorController.EXTERIOR_URI)
public class ExteriorController {
    public static final String EXTERIOR_URI = "/api/exterior";
    private ExteriorService exteriorService;

    public ExteriorController(ExteriorService exteriorService) {
        this.exteriorService = exteriorService;
    }

    @PostMapping
    public ResponseEntity<ExteriorDTO> addNewExterior(@RequestBody ExteriorDTO exteriorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(exteriorService.createExterior(exteriorDTO));
    }
    @GetMapping("/{exteriorId}")
    public ResponseEntity<ExteriorDTO> findExteriorById(@PathVariable Long exteriorId) {
        return ResponseEntity.ok(exteriorService.findByExteriorId(exteriorId));
    }
}
