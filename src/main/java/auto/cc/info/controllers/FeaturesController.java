package auto.cc.info.controllers;

import auto.cc.info.commands.DimensionsAndWeightCommand;
import auto.cc.info.commands.FeaturesCommand;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.FeaturesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("/api/features")
@Slf4j
public class FeaturesController {
    private FeaturesService featuresService;
    @Autowired
    public void setFeaturesService(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public FeaturesCommand addNewCarFeatures(@RequestBody FeaturesCommand featuresCommand){
        Optional<FeaturesCommand> featuresCommandOptional = Optional.ofNullable(featuresService.addNewCarFeatures(featuresCommand));
        if(!featuresCommandOptional.isPresent()){
            log.error("Your new brand not added failed process !!!");
            return null;
        }
        else {
            return featuresCommandOptional.get();
        }
    }
    @QueryMapping(name = "findFeaturesById")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public FeaturesCommand findFeaturesById(@Argument Long id) {
        FeaturesCommand featuresCommand = featuresService.findFeaturesById(id);
        return featuresCommand;
    }

}
