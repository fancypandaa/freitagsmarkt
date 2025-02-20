package auto.freitagsmarkt.service.impl.specs;


import auto.freitagsmarkt.dto.specs.FeaturesDTO;
import auto.freitagsmarkt.mapper.specs.FeaturesMapper;
import auto.freitagsmarkt.repository.specs.FeaturesRepository;
import auto.freitagsmarkt.service.specs.FeaturesService;
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
        return Optional.ofNullable(featuresDTO)
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
