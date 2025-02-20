package auto.freitagsmarkt.controller.otherComponents;


import auto.freitagsmarkt.dto.components.FuelDTO;
import auto.freitagsmarkt.service.otherComponents.FuelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(FuelController.FUEL_URI)
public class FuelController {
    public static final String FUEL_URI= "/api/fuel";
    private FuelService fuelService;

    public FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }
    @PostMapping
    public ResponseEntity<FuelDTO> addFuelInfo(@RequestBody FuelDTO fuelDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(fuelService.addFuelInfo(fuelDTO));
    }
    @GetMapping("/{fuelId}")
    public ResponseEntity<FuelDTO> getFuelById(@PathVariable Long fuelId){
        return ResponseEntity.ok(fuelService.findFuelById(fuelId));
    }
}
