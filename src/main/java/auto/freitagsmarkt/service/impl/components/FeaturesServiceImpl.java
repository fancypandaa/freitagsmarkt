package auto.freitagsmarkt.service.impl.components;


import auto.freitagsmarkt.dto.components.FeaturesDTO;
import auto.freitagsmarkt.mapper.components.FeaturesMapper;
import auto.freitagsmarkt.repository.components.FeaturesRepository;
import auto.freitagsmarkt.service.components.FeaturesService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeaturesServiceImpl implements FeaturesService {

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
