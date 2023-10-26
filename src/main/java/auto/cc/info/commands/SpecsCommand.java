package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class SpecsCommand {
    private Long id;
    private EngineCommand engine;
    private DimensionsAndWeightCommand dimensionsAndWeight;
    private ExteriorCommand exterior;
    private InteriorCommand interior;
    private FeaturesCommand features;
    private SafetyAndSecurityCommand safetyAndSecurity;
}
