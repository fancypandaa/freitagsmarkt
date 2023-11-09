package auto.cc.info.service;

import auto.cc.info.commands.DimensionsAndWeightCommand;

public interface DimAndWeightService {
    DimensionsAndWeightCommand addNewDimAndWeight(DimensionsAndWeightCommand dimensionsAndWeightCommand);
    DimensionsAndWeightCommand findDimensionsAndWeighById(Long id);
}
