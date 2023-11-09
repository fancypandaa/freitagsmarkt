package auto.cc.info.converters;

import auto.cc.info.commands.CarCommand;
import auto.cc.info.domain.Car;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CarToCarCommand implements Converter<Car, CarCommand> {
    private final EngineToEngineCommand engineToEngineCommand;
    private final DimAndWeightToDimAndWeightCommand dimensionsConverter;
    private final ExteriorToExteriorCommand exteriorCommand;
    private final  InteriorToInteriorCommand interiorToInteriorCommand;
    private final FeaturesToFeaturesCommand featuresCommandConverter;
    private final SafetyAndSecurityToSafetyAndSecurityCommand securityToSafetyAndSecurityCommand;

    public CarToCarCommand(EngineToEngineCommand engineToEngineCommand, DimAndWeightToDimAndWeightCommand dimensionsConverter, ExteriorToExteriorCommand exteriorCommand, InteriorToInteriorCommand interiorToInteriorCommand, FeaturesToFeaturesCommand featuresCommandConverter, SafetyAndSecurityToSafetyAndSecurityCommand securityToSafetyAndSecurityCommand) {
        this.engineToEngineCommand = engineToEngineCommand;
        this.dimensionsConverter = dimensionsConverter;
        this.exteriorCommand = exteriorCommand;
        this.interiorToInteriorCommand = interiorToInteriorCommand;
        this.featuresCommandConverter = featuresCommandConverter;
        this.securityToSafetyAndSecurityCommand = securityToSafetyAndSecurityCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public CarCommand convert(Car source) {
        if (source == null) {
            return null;
        }
        final CarCommand carCommand = new CarCommand();
        carCommand.setId(source.getId());
        carCommand.setDays(source.getDays());
        carCommand.setCity(source.getCity());
        carCommand.setModel(source.getModel());
        carCommand.setGeneration(source.getGeneration());
        carCommand.setMileage(source.getMileage());
        carCommand.setPrice(source.getPrice());
        carCommand.setSaleStatus(source.getSaleStatus());
        carCommand.setCarBrandId(source.getCarBrand().getId());
        carCommand.setSellerId(source.getSeller().getId());
        carCommand.setEngine(engineToEngineCommand.convert(source.getEngine()));
        carCommand.setDimensionsAndWeight(dimensionsConverter.convert(source.getDimensionsAndWeight()));
        carCommand.setExterior(exteriorCommand.convert(source.getExterior()));
        carCommand.setInterior(interiorToInteriorCommand.convert(source.getInterior()));
        carCommand.setFeatures(featuresCommandConverter.convert(source.getFeatures()));
        carCommand.setSafetyAndSecurity(securityToSafetyAndSecurityCommand.convert(source.getSafetyAndSecurity()));
        return carCommand;
    }
}
