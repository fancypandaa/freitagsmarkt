package auto.freitagsmarkt.service.specs;


import auto.freitagsmarkt.dto.specs.DimensionsWeightDTO;

public interface DimensionsWeightService {
    DimensionsWeightDTO addNewDimAndWeight(DimensionsWeightDTO dimensionsWeightDTO);
    DimensionsWeightDTO findDimensionsAndWeighById(Long id);
}
