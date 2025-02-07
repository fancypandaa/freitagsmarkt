package auto.freitagsmarkt.service.components;


import auto.freitagsmarkt.dto.components.FeaturesDTO;

public interface FeaturesService {
    FeaturesDTO addNewCarFeatures(FeaturesDTO featuresDTO);
    FeaturesDTO findFeaturesById(Long featuresId);
}
