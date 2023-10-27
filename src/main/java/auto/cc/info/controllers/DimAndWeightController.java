package auto.cc.info.controllers;

import auto.cc.info.commands.DimensionsAndWeightCommand;
import auto.cc.info.service.DimAndWeightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/weight")
@Slf4j
public class DimAndWeightController{
    private DimAndWeightService dimAndWeightService;
    @Autowired
    public void setDimAndWeightService(DimAndWeightService dimAndWeightService) {
        this.dimAndWeightService = dimAndWeightService;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public DimensionsAndWeightCommand addNewCarDimensionAndWeight(@RequestBody DimensionsAndWeightCommand dimensionsAndWeightCommand){
        Optional<DimensionsAndWeightCommand> dimensionsAndWeightCommandOptional = Optional.ofNullable(dimAndWeightService.addNewDimAndWeight(dimensionsAndWeightCommand));
        if(!dimensionsAndWeightCommandOptional.isPresent()){
            log.error("Your new brand not added failed process !!!");
            return null;
        }
        else {
            return dimensionsAndWeightCommandOptional.get();
        }
    }
}