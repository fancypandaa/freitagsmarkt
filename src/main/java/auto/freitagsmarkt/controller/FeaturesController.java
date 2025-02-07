package auto.freitagsmarkt.controller;


import auto.freitagsmarkt.dto.car.otherComponents.FeaturesDTO;
import auto.freitagsmarkt.service.FeaturesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(FeaturesController.FEATURES_URI)
public class FeaturesController {
    public static final String FEATURES_URI= "/api/features";
    private FeaturesService featuresService;

    public FeaturesController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }
    @PostMapping
    public ResponseEntity<FeaturesDTO> addNewCarFeatures(@RequestBody FeaturesDTO featuresDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(featuresService.addNewCarFeatures(featuresDTO));
    }
    @GetMapping("/{featureId}")
    public ResponseEntity<FeaturesDTO> findFeaturesById(@PathVariable Long featureId) {
        return ResponseEntity.ok(featuresService.findFeaturesById(featureId));
    }
}
