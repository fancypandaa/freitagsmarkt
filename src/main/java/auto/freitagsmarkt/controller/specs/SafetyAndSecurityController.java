package auto.freitagsmarkt.controller.specs;

import auto.freitagsmarkt.dto.specs.SafetyAndSecurityDTO;
import auto.freitagsmarkt.service.specs.SafetyAndSecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(SafetyAndSecurityController.SAFETY_URI)
public class SafetyAndSecurityController {
    public static final String SAFETY_URI ="/api/safetyAndSecurity";
    private SafetyAndSecurityService safetyAndSecurityService;
    public SafetyAndSecurityController(SafetyAndSecurityService safetyAndSecurityService) {
        this.safetyAndSecurityService = safetyAndSecurityService;
    }
    @PostMapping
    public ResponseEntity<SafetyAndSecurityDTO> addNewCarFeatures(@RequestBody SafetyAndSecurityDTO safetyAndSecurityDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(safetyAndSecurityService.addNewSafetyAndSecurity(safetyAndSecurityDTO));
    }
    @GetMapping("/{safetyId}")
    public ResponseEntity<SafetyAndSecurityDTO> findBySecurityId(@PathVariable Long safetyId) {
        return ResponseEntity.ok(safetyAndSecurityService.findBySafetyAndSecurityId(safetyId));
    }
}
