package auto.cc.info.converters;

import auto.cc.info.commands.SpecsCommand;
import auto.cc.info.domain.Specs;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SpecsToSpecsCommand implements Converter<Specs,SpecsCommand> {
    private final EngineToEngineCommand engineToEngineCommand;
    private final DimAndWeightToDimAndWeightCommand dimensionsConverter;
    private final ExteriorToExteriorCommand exteriorCommand;
    private final  InteriorToInteriorCommand interiorToInteriorCommand;
    private final FeaturesToFeaturesCommand featuresCommandConverter;
    private final SafetyAndSecurityToSafetyAndSecurityCommand securityToSafetyAndSecurityCommand;

    public SpecsToSpecsCommand(EngineToEngineCommand engineToEngineCommand, DimAndWeightToDimAndWeightCommand dimensionsConverter, ExteriorToExteriorCommand exteriorCommand, InteriorToInteriorCommand interiorToInteriorCommand, FeaturesToFeaturesCommand featuresCommandConverter, SafetyAndSecurityToSafetyAndSecurityCommand securityToSafetyAndSecurityCommand) {
        this.engineToEngineCommand = engineToEngineCommand;
        this.dimensionsConverter = dimensionsConverter;
        this.exteriorCommand = exteriorCommand;
        this.interiorToInteriorCommand = interiorToInteriorCommand;
        this.featuresCommandConverter = featuresCommandConverter;
        this.securityToSafetyAndSecurityCommand = securityToSafetyAndSecurityCommand;
    }

    @Override
    @Synchronized
    @Nullable
    public SpecsCommand convert(Specs source) {
        if(source == null) return null;
        final SpecsCommand specsCommand = new SpecsCommand();
        specsCommand.setId(source.getId());
        specsCommand.setEngine(engineToEngineCommand.convert(source.getEngine()));
        specsCommand.setDimensionsAndWeight(dimensionsConverter.convert(source.getDimensionsAndWeight()));
        specsCommand.setExterior(exteriorCommand.convert(source.getExterior()));
        specsCommand.setInterior(interiorToInteriorCommand.convert(source.getInterior()));
        specsCommand.setFeatures(featuresCommandConverter.convert(source.getFeatures()));
        specsCommand.setSafetyAndSecurity(securityToSafetyAndSecurityCommand.convert(source.getSafetyAndSecurity()));
        return specsCommand;
    }
}
