package auto.cc.info.service;

import auto.cc.info.dto.otherComponents.FeaturesCommand;

public interface FeaturesService {
    FeaturesCommand addNewCarFeatures(FeaturesCommand featuresCommand);
    FeaturesCommand findFeaturesById(Long id);
}
