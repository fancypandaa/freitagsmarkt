package auto.freitagsmarkt.controller.carSpecs;

import auto.freitagsmarkt.dto.carSpecs.TransmissionCommand;
import auto.freitagsmarkt.dto.custom.ITransmissionCustom;
import auto.freitagsmarkt.domain.user.Constants;
import auto.freitagsmarkt.dto.specs.TransmissionDTO;
import auto.freitagsmarkt.service.specs.TransmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TransmissionsController.TRANSMISSION_URI)
public class TransmissionsController {
    public static final String TRANSMISSION_URI ="/api/transmissions";
    private TransmissionService transmissionService;
    @PostMapping
    public ResponseEntity<TransmissionDTO> addTransmissionInfo(@RequestBody TransmissionDTO transmissionDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(transmissionService.createNewTransmissionsItems(transmissionDTO));
    }
    @GetMapping("/{transId}")
    public ResponseEntity<TransmissionDTO> getTransmissionById(@PathVariable Long transId){
        return ResponseEntity.ok(transmissionService.findTransmissionsById(transId));
    }
}
