package auto.freitagsmarkt.controller.otherComponents;

import auto.freitagsmarkt.dto.components.BrakesDTO;
import auto.freitagsmarkt.service.otherComponents.BrakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static auto.freitagsmarkt.controller.otherComponents.BrakesController.ADS_URI;

@RestController
@RequestMapping(ADS_URI)
public class BrakesController {
    public static final String ADS_URI = "/api/brakes";
    private BrakesService brakesService;
    @Autowired
    public void setBrakesService(BrakesService brakesService) {
        this.brakesService = brakesService;
    }

    @PostMapping
    public ResponseEntity<BrakesDTO> addNewBrakes(@RequestBody BrakesDTO brakesDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(brakesService.addBrakes(brakesDTO));
    }
    @GetMapping("/{brakesId}")
    public ResponseEntity<BrakesDTO> findBrakesById(@PathVariable Long brakesId) {
        return ResponseEntity.ok(brakesService.findBrakesById(brakesId));
    }
    @PutMapping("/{brakesId}")
    public ResponseEntity<BrakesDTO> updateBrakesById(@PathVariable Long brakesId,@RequestBody BrakesDTO brakesDTO){
        return ResponseEntity.ok(brakesService.updateBrakesById(brakesId,brakesDTO));
    }
}
