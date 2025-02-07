package auto.freitagsmarkt.service;


import auto.freitagsmarkt.dto.car.otherComponents.FeaturesDTO;

public interface FeaturesService {
    FeaturesDTO addNewCarFeatures(FeaturesDTO featuresDTO);
    FeaturesDTO findFeaturesById(Long featuresId);
}
