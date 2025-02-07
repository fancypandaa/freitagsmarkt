package auto.freitagsmarkt.service;


import auto.freitagsmarkt.dto.car.otherComponents.FeaturesDTO;
import auto.freitagsmarkt.mapper.otherComponents.FeaturesMapper;
import auto.freitagsmarkt.repository.FeaturesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeaturesServiceImpl implements FeaturesService{

    private FeaturesMapper featuresMapper;
    private FeaturesRepository featuresRepository;

    public FeaturesServiceImpl(FeaturesMapper featuresMapper, FeaturesRepository featuresRepository) {
        this.featuresMapper = featuresMapper;
        this.featuresRepository = featuresRepository;
    }

    @Override
    public FeaturesDTO addNewCarFeatures(FeaturesDTO featuresDTO) {
        return Optional.of(featuresDTO)
                .map(featuresMapper::toFeatures)
                .map(featuresRepository::save)
                .map(featuresMapper::toFeaturesDTO)
                .orElseThrow(() -> new RuntimeException("Cannot create New car feature"));
    }

    @Override
    public FeaturesDTO findFeaturesById(Long featuresId) {
        return featuresRepository.findById(featuresId)
                .map(featuresMapper::toFeaturesDTO)
                .orElseThrow(()-> new RuntimeException("Feature not found"));
    }
}
