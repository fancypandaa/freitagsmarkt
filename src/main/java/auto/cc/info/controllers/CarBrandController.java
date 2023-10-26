package auto.cc.info.controllers;

import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.service.CarBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/car_brand")
@Slf4j
public class CarBrandController {
  private CarBrandService carBrandService;
    @Autowired
    public void setCarBrandService(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }
    @RequestMapping(value = "/car_brand_list", method= RequestMethod.GET, produces = "application/json")
    public Page<CarBrandCommand> listAllBrands(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "10") int size){
        Page<CarBrandCommand> carBrandsCommands = carBrandService.listCarBrands(page,size);
        return carBrandsCommands;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public CarBrandCommand addNewBrand(@RequestBody CarBrandCommand carBrandCommand){
        Optional<CarBrandCommand> carBrandCommandOptional = Optional.ofNullable(carBrandService.addNewCarBrand(carBrandCommand));
        if(!carBrandCommandOptional.isPresent()){
            log.error("Your new brand not added failed process !!!");
            return null;
        }
        else {
            return carBrandCommandOptional.get();
        }
    }
}
