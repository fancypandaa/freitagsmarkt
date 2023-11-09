package auto.cc.info.service;

import auto.cc.info.commands.FeaturesCommand;
import auto.cc.info.converters.FeaturesCommandToFeatures;
import auto.cc.info.converters.FeaturesToFeaturesCommand;
import auto.cc.info.domain.Features;
import auto.cc.info.repository.FeaturesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class FeaturesServiceImpl implements FeaturesService{
    private final FeaturesRepository featuresRepository;
    private final FeaturesCommandToFeatures featuresCommandToFeatures;
    private final FeaturesToFeaturesCommand featuresToFeaturesCommand;

    public FeaturesServiceImpl(FeaturesRepository featuresRepository, FeaturesCommandToFeatures featuresCommandToFeatures, FeaturesToFeaturesCommand featuresToFeaturesCommand) {
        this.featuresRepository = featuresRepository;
        this.featuresCommandToFeatures = featuresCommandToFeatures;
        this.featuresToFeaturesCommand = featuresToFeaturesCommand;
    }

    @Override
    @Transactional
    public FeaturesCommand addNewCarFeatures(FeaturesCommand featuresCommand) {
        if(featuresCommand.getAccessories() == null){
            return new FeaturesCommand();
        }
        Features features= featuresCommandToFeatures.convert(featuresCommand);
        featuresRepository.save(features);
        return featuresCommand;
    }

    @Override
    public FeaturesCommand findFeaturesById(Long id) {
        Optional<Features> features = featuresRepository.findById(id);
        if(!features.isPresent()){
            return null;
        }
        return featuresToFeaturesCommand.convert(features.get());
    }
}
