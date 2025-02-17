package auto.freitagsmarkt.controller.car;


import auto.freitagsmarkt.dto.car.CarDTO;
import auto.freitagsmarkt.service.car.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(CarController.CAR_URI)
public class CarController {
    public static final String CAR_URI = "/api/car";
    private CarService carService;
    @GetMapping("/all-cars")
    public ResponseEntity<List<CarDTO>> listAllCars(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.ok(carService.listCars(page, size));
    }
    @GetMapping("/{carId}")
    public ResponseEntity<CarDTO> findCarById(@PathVariable Long carId) {
        return ResponseEntity.ok(carService.findCarById(carId));
    }

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @PostMapping
    public ResponseEntity<CarDTO> addNewCar(@RequestBody CarDTO carDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.addNewCar(carDTO));
    }
    @PatchMapping("/{carId}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long carId, @RequestBody CarDTO carDTO){
        return ResponseEntity.ok(carService.updateCarById(carId,carDTO));
    }
    @DeleteMapping("/{carId}")
    public ResponseEntity<String> deleteCarById(@PathVariable Long carId){
        return (carService.removeCarById(carId)?
                ResponseEntity.ok("Car deleted successfully!!"):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car with the given ID does not exist"));
    }
}
