package auto.cc.info.service;

import auto.cc.info.commands.DimensionsAndWeightCommand;
import auto.cc.info.converters.DimAndWeightCommandToDimAndWeight;
import auto.cc.info.converters.DimAndWeightToDimAndWeightCommand;
import auto.cc.info.domain.DimensionsAndWeight;
import auto.cc.info.repository.DimAndWeightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class DimAndWeightServiceImpl implements DimAndWeightService{
    private final DimAndWeightRepository dimAndWeightRepository;
    private final DimAndWeightCommandToDimAndWeight dimCommandToDim;
    private final DimAndWeightToDimAndWeightCommand dimToDimCommand;
    public DimAndWeightServiceImpl(DimAndWeightRepository dimAndWeightRepository, DimAndWeightCommandToDimAndWeight dimCommandToDim, DimAndWeightToDimAndWeightCommand dimToDimCommand) {
        this.dimAndWeightRepository = dimAndWeightRepository;
        this.dimCommandToDim = dimCommandToDim;
        this.dimToDimCommand = dimToDimCommand;
    }
    @Override
    @Transactional
    public DimensionsAndWeightCommand addNewDimAndWeight(DimensionsAndWeightCommand dimensionsAndWeightCommand) {
        DimensionsAndWeight dimensionsAndWeight= dimCommandToDim.convert(dimensionsAndWeightCommand);
        dimAndWeightRepository.save(dimensionsAndWeight);
        return dimensionsAndWeightCommand;
    }
    @Override
    @Transactional
    public DimensionsAndWeightCommand findDimensionsAndWeighById(Long id) {
        DimensionsAndWeight dimensionsAndWeight= dimAndWeightRepository.getById(id);
        if(dimensionsAndWeight.getId() == null){
            return null;
        }
        return dimToDimCommand.convert(dimensionsAndWeight);
    }
}
