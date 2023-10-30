package auto.cc.info.controllers;

import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.service.CarBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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
    @QueryMapping(name = "listAllBrands")
    public Page<CarBrandCommand> listAllBrands(@Argument int page, @Argument int size){
        Page<CarBrandCommand> carBrandsCommands = carBrandService.listCarBrands(page,size);
        return carBrandsCommands;
    }
}
