package auto.freitagsmarkt.controller.car;

import auto.freitagsmarkt.dto.car.CarBrandDTO;
import auto.freitagsmarkt.service.car.CarBrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CarBrandController.CarBrandURI)
public class CarBrandController {
    public static final String CarBrandURI = "/api/carBrand";
    private CarBrandService carBrandService;

    public CarBrandController(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }
    @GetMapping("/carBrand-list")
    public ResponseEntity<List<CarBrandDTO>> listAllBrands(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(carBrandService.listCarBrands(page,size));
    }
    @GetMapping("/{carBrandId}")
    public ResponseEntity<CarBrandDTO> findCarBrandById(@PathVariable Long carBrandId) {
        return ResponseEntity.ok(carBrandService.findCarBrandById(carBrandId));
    }
    @PostMapping
    public ResponseEntity<CarBrandDTO> addNewBrand(@RequestBody CarBrandDTO carBrandDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(carBrandService.addNewCarBrand(carBrandDTO));
    }
    @PatchMapping("/{carBrandId}")
    public ResponseEntity<CarBrandDTO> updateCarBrand(@PathVariable Long carBrandId, @RequestBody CarBrandDTO carBrandDTO){
        return ResponseEntity.ok(carBrandService.updateCarBrand(carBrandId,carBrandDTO));
    }
    @DeleteMapping("/{carBrandId}")
    public void deleteBrandById(@PathVariable Long carBrandId){
        carBrandService.removeCarBrandById(carBrandId);
    }

}
