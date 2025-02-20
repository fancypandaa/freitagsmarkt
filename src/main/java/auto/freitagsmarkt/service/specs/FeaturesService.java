package auto.freitagsmarkt.service.specs;


import auto.freitagsmarkt.dto.specs.FeaturesDTO;

public interface FeaturesService {
    FeaturesDTO addNewCarFeatures(FeaturesDTO featuresDTO);
    FeaturesDTO findFeaturesById(Long featuresId);
}
