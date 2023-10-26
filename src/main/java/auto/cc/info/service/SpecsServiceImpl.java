package auto.cc.info.service;

import auto.cc.info.commands.SpecsCommand;
import auto.cc.info.converters.SpecsCommandToSpecs;
import auto.cc.info.converters.SpecsToSpecsCommand;
import auto.cc.info.domain.Engine;
import auto.cc.info.domain.Features;
import auto.cc.info.domain.Specs;
import auto.cc.info.repository.EngineRepository;
import auto.cc.info.repository.FeaturesRepository;
import auto.cc.info.repository.SpecsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class SpecsServiceImpl implements SpecsService{
    private final SpecsRepository repository;
    private final SpecsToSpecsCommand specsToSpecsCommand;
    private final SpecsCommandToSpecs toSpecs;
    private final EngineRepository engineRepository;
    private final FeaturesRepository featuresRepository;

    public SpecsServiceImpl(SpecsRepository repository, SpecsToSpecsCommand specsToSpecsCommand, SpecsCommandToSpecs toSpecs, EngineRepository engineRepository, FeaturesRepository featuresRepository) {
        this.repository = repository;
        this.specsToSpecsCommand = specsToSpecsCommand;
        this.toSpecs = toSpecs;
        this.engineRepository = engineRepository;
        this.featuresRepository = featuresRepository;
    }

    @Override
    @Transactional
    public SpecsCommand createNewSpecs(SpecsCommand specsCommand) {
        Optional<Engine> engineOptional = engineRepository.findById(specsCommand.getEngine().getId());
        Optional<Features> featuresOptional = featuresRepository.findById(specsCommand.getFeatures().getId());

        if(!engineOptional.isPresent() || !featuresOptional.isPresent()) {
            return new SpecsCommand();
        }
        Specs specs = toSpecs.convert(specsCommand);
        repository.save(specs);
        return specsCommand;
    }
}
