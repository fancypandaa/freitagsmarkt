package auto.cc.info.converters;

import auto.cc.info.commands.*;
import auto.cc.info.domain.Specs;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SpecsCommandToSpecs implements Converter<SpecsCommand, Specs> {
    private final EngineCommandToEngine engineCommandToEngine;
    private final DimensionsAndWeightCommandToDimensionsAndWeight commandToDimensionsAndWeight;
    private final ExteriorCommandToExterior exteriorCommandToExterior;
    private final  InteriorCommandToInterior commandToInterior;
    private final FeaturesCommandToFeatures featuresCommandToFeatures;
    private final SafetyAndSecurityCommandToSafetyAndSecurity commandToSafetyAndSecurity;

    public SpecsCommandToSpecs(EngineCommandToEngine engineCommandToEngine, DimensionsAndWeightCommandToDimensionsAndWeight commandToDimensionsAndWeight, ExteriorCommandToExterior exteriorCommandToExterior, InteriorCommandToInterior commandToInterior, FeaturesCommandToFeatures featuresCommandToFeatures, SafetyAndSecurityCommandToSafetyAndSecurity commandToSafetyAndSecurity) {
        this.engineCommandToEngine = engineCommandToEngine;
        this.commandToDimensionsAndWeight = commandToDimensionsAndWeight;
        this.exteriorCommandToExterior = exteriorCommandToExterior;
        this.commandToInterior = commandToInterior;
        this.featuresCommandToFeatures = featuresCommandToFeatures;
        this.commandToSafetyAndSecurity = commandToSafetyAndSecurity;
    }

    @Override
    @Transactional
    @Nullable
    public Specs convert(SpecsCommand source) {
        if(source == null) return null;
        final Specs specs= new Specs();
        specs.setId(source.getId());
        specs.setEngine(engineCommandToEngine.convert(source.getEngine()));
        specs.setDimensionsAndWeight(commandToDimensionsAndWeight.convert(source.getDimensionsAndWeight()));
        specs.setExterior(exteriorCommandToExterior.convert(source.getExterior()));
        specs.setInterior(commandToInterior.convert(source.getInterior()));
        specs.setFeatures(featuresCommandToFeatures.convert(source.getFeatures()));
        specs.setSafetyAndSecurity(commandToSafetyAndSecurity.convert(source.getSafetyAndSecurity()));
        return  specs;
    }
}
