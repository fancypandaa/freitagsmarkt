package auto.freitagsmarkt.controller.specs;

import auto.freitagsmarkt.dto.specs.DimensionsWeightDTO;
import auto.freitagsmarkt.service.specs.DimensionsWeightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DimensionsWeightController.DimensionsWeight_URI)
public class DimensionsWeightController {
    public static final String DimensionsWeight_URI="/api/dimensionsWeight";
    private DimensionsWeightService dimensionsWeightService;

    public DimensionsWeightController(DimensionsWeightService dimensionsWeightService) {
        this.dimensionsWeightService = dimensionsWeightService;
    }

    @PostMapping
    public ResponseEntity<DimensionsWeightDTO> addNewCarDimensionAndWeight(
            @RequestBody DimensionsWeightDTO dimensionsWeightDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dimensionsWeightService.addNewDimAndWeight(dimensionsWeightDTO));
    }

    @GetMapping("/{dimId}")
     public ResponseEntity<DimensionsWeightDTO> findDimAndWeightById(@PathVariable Long dimId) {
        return ResponseEntity.ok(dimensionsWeightService.findDimensionsAndWeighById(dimId));
    }
}
