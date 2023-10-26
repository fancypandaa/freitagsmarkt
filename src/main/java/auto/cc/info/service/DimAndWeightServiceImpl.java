package auto.cc.info.service;

import auto.cc.info.commands.DimensionsAndWeightCommand;
import auto.cc.info.converters.DimensionsAndWeightCommandToDimensionsAndWeight;
import auto.cc.info.converters.DimensionsAndWeightToDimensionsAndWeightCommand;
import auto.cc.info.domain.DimensionsAndWeight;
import auto.cc.info.repository.DimAndWeightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class DimAndWeightServiceImpl implements DimAndWeightService{
    private final DimAndWeightRepository dimAndWeightRepository;
    private final DimensionsAndWeightCommandToDimensionsAndWeight dimCommandTodim;
    private final DimensionsAndWeightToDimensionsAndWeightCommand dimToDimCommand;

    public DimAndWeightServiceImpl(DimAndWeightRepository dimAndWeightRepository, DimensionsAndWeightCommandToDimensionsAndWeight dimCommandTodim, DimensionsAndWeightToDimensionsAndWeightCommand dimToDimCommand) {
        this.dimAndWeightRepository = dimAndWeightRepository;
        this.dimCommandTodim = dimCommandTodim;
        this.dimToDimCommand = dimToDimCommand;
    }


    @Override
    @Transactional

    public DimensionsAndWeightCommand addNewDimAndWeight(DimensionsAndWeightCommand dimensionsAndWeightCommand) {
        DimensionsAndWeight dimensionsAndWeight= dimCommandTodim.convert(dimensionsAndWeightCommand);
        dimAndWeightRepository.save(dimensionsAndWeight);
        return dimensionsAndWeightCommand;
    }
}
