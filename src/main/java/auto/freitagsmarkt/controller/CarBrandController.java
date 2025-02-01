package auto.cc.info.controller;

import auto.cc.info.dto.car.CarBrandDTO;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.CarBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("/api/car_brand")
@Slf4j
public class CarBrandController {
  private CarBrandService carBrandService;
    @Autowired
    public void setCarBrandService(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public CarBrandDTO addNewBrand(@RequestBody CarBrandDTO carBrandCommand){
        Optional<CarBrandDTO> carBrandCommandOptional = Optional.ofNullable(carBrandService.addNewCarBrand(carBrandCommand));
        if(!carBrandCommandOptional.isPresent()){
            log.error("Your new brand not added failed process !!!");
            return null;
        }
        else {
            return carBrandCommandOptional.get();
        }
    }
    @RequestMapping(value = "/{carBrandId}",method = RequestMethod.PATCH,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public CarBrandDTO updateCarBrand(@PathVariable Long carBrandId, @RequestBody CarBrandDTO carBrandCommand){
        CarBrandDTO carBrandCommandI = carBrandService.updateCarBrand(carBrandId,carBrandCommand);
        return carBrandCommandI;
    }
    @RequestMapping(value = "/{carBrandId}",method = RequestMethod.DELETE,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public void deleteBrandById(@PathVariable Long carBrandId){
        carBrandService.removeCarBrandById(carBrandId);
    }
    @QueryMapping(name = "listAllBrands")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public Page<CarBrandDTO> listAllBrands(@Argument int page, @Argument int size){
        Page<CarBrandDTO> carBrandsCommands = carBrandService.listCarBrands(page,size);
        return carBrandsCommands;
    }
    @QueryMapping(name = "findCarBrandById")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public CarBrandDTO findCarBrandById(@Argument Long id) {
        CarBrandDTO carBrandCommand = carBrandService.findCarBrandById(id);
        return carBrandCommand;
    }

    @QueryMapping(name = "findByProductionYearsAndSeries")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public Page<CarBrandDTO> findByProductionYearsAndSeries(@Argument Integer page, @Argument Integer size,
                                                            @Argument Optional<String> series,
                                                            @Argument Optional<Integer> productionYears){
        Page<CarBrandDTO> carBrandsCommands = carBrandService.findByProductionYearsAndSeries(page,size,series,productionYears);
        return carBrandsCommands;
    }
}
