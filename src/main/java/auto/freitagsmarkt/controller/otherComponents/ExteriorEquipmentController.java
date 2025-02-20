package auto.freitagsmarkt.controller.otherComponents;

import auto.freitagsmarkt.dto.components.ExteriorEquipmentDTO;
import auto.freitagsmarkt.service.otherComponents.ExteriorEquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ExteriorEquipmentController.EXTERIOR_EQUIPMENT_URI)
public class ExteriorEquipmentController
{
    public static final String EXTERIOR_EQUIPMENT_URI = "/api/exteriorEquipment";
    private ExteriorEquipmentService exteriorEquipmentService;

    public ExteriorEquipmentController(ExteriorEquipmentService exteriorEquipmentService) {
        this.exteriorEquipmentService = exteriorEquipmentService;
    }
    @GetMapping("/{exId}")
    public ResponseEntity<ExteriorEquipmentDTO> getExteriorEquipment(@PathVariable Long exId){
        return ResponseEntity.ok(exteriorEquipmentService.findExteriorEquipmentById(exId));
    }

    @PostMapping
    public ResponseEntity<ExteriorEquipmentDTO> createNewExteriorEquipment(@RequestBody ExteriorEquipmentDTO exteriorEquipmentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(exteriorEquipmentService.createExteriorEquipment(exteriorEquipmentDTO));
    }
}
