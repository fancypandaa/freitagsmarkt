package auto.freitagsmarkt.controller.otherComponents;

import auto.freitagsmarkt.dto.components.SuspensionsDTO;
import auto.freitagsmarkt.service.otherComponents.SuspensionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SuspensionsController.SUSPENSIONS_URI)
public class SuspensionsController {
    public static final String SUSPENSIONS_URI = "/api/suspensions";
    private SuspensionsService suspensionsService;
    @PostMapping
    public ResponseEntity<SuspensionsDTO> addSuspensionsInfo(@RequestBody SuspensionsDTO suspensionsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(suspensionsService.createNewSuspensionsItems(suspensionsDTO));
    }
}
