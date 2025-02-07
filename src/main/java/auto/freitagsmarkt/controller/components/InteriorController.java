package auto.freitagsmarkt.controller.components;

import auto.freitagsmarkt.dto.components.InteriorDTO;
import auto.freitagsmarkt.domain.user.Constants;
import auto.freitagsmarkt.service.components.InteriorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
