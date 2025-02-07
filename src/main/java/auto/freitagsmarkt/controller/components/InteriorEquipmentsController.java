package auto.freitagsmarkt.controller.components;

import auto.freitagsmarkt.dto.components.InteriorEquipmentsDTO;
import auto.freitagsmarkt.service.components.InteriorEquipmentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(InteriorController.INTERIOR_URI)
public class InteriorEquipmentsController {
    public static final String INTERIOREQ_URI="/api/interiorEQ";
    private InteriorEquipmentsService interiorEquipmentsService;

    public InteriorEquipmentsController(InteriorEquipmentsService interiorEquipmentsService) {
        this.interiorEquipmentsService = interiorEquipmentsService;
    }
    @PostMapping
    public ResponseEntity<InteriorEquipmentsDTO> addNewInteriorEquipment(@RequestBody InteriorEquipmentsDTO interiorEquipmentsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(interiorEquipmentsService.createNewInteriorEquipment(interiorEquipmentsDTO));
    }
    @GetMapping("/{equipmentId}")
    public ResponseEntity<InteriorEquipmentsDTO> findInteriorEquipmentId(@PathVariable Long equipmentId) {
        return ResponseEntity.ok(interiorEquipmentsService.findInteriorEquipmentById(equipmentId));
    }
}
