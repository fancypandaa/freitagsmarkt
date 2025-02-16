package auto.freitagsmarkt.controller.components;

import auto.freitagsmarkt.dto.components.ExteriorEquipmentDTO;
import auto.freitagsmarkt.service.components.ExteriorEquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ExteriorEquipmentController.EXTERIOREQ_URI)
public class ExteriorEquipmentController
{
    public static final String EXTERIOREQ_URI = "/api/exteriorEquip";
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
