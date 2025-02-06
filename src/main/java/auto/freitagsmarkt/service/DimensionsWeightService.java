package auto.freitagsmarkt.service;


import auto.freitagsmarkt.dto.car.specs.DimensionsWeightDTO;

public interface DimensionsWeightService {
    DimensionsWeightDTO addNewDimAndWeight(DimensionsWeightDTO dimensionsWeightDTO);
    DimensionsWeightDTO findDimensionsAndWeighById(Long id);
}
