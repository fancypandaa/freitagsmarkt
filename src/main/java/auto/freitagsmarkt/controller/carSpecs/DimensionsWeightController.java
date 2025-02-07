package auto.freitagsmarkt.controller.carSpecs;

import auto.freitagsmarkt.dto.specs.DimensionsWeightDTO;
import auto.freitagsmarkt.service.specs.DimensionsWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DimensionsWeightController.DimensionsWeight_URI)
public class DimensionsWeightController {
    public static final String DimensionsWeight_URI="/api/weight";
    private DimensionsWeightService dimensionsWeightService;
    @Autowired
    public void setDimAndWeightService(DimensionsWeightService dimensionsWeightService) {
        this.dimensionsWeightService = dimensionsWeightService;
        }
    @PostMapping
    public ResponseEntity<DimensionsWeightDTO> addNewCarDimensionAndWeight(
            @RequestBody DimensionsWeightDTO dimensionsWeightDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dimensionsWeightService.addNewDimAndWeight(dimensionsWeightDTO));
    }

    @GetMapping("/{id}")
     public ResponseEntity<DimensionsWeightDTO> findDimAndWeightById(@PathVariable Long id) {
        return ResponseEntity.ok(dimensionsWeightService.findDimensionsAndWeighById(id));
    }
}
