package auto.freitagsmarkt.service;


import auto.freitagsmarkt.dto.car.specs.DimensionsWeightDTO;
import auto.freitagsmarkt.mapper.specs.DimensionsWeightMapper;
import auto.freitagsmarkt.repository.DimensionsWeightRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DimensionsWeightServiceImpl implements DimensionsWeightService {

    private DimensionsWeightMapper dimensionsWeightMapper;
    private DimensionsWeightRepository dimensionsWeightRepository;

    @Override
    public DimensionsWeightDTO addNewDimAndWeight(DimensionsWeightDTO dimensionsWeightDTO) {
        return Optional.of(dimensionsWeightDTO)
                .map(dimensionsWeightMapper::toDimensionWeight)
                .map(dimensionsWeightRepository::save)
                .map(dimensionsWeightMapper::toDimensionsWeightDTO)
                .orElseThrow(() -> new RuntimeException("Cannot create DimensionsWeight"));
    }

    @Override
    public DimensionsWeightDTO findDimensionsAndWeighById(Long id) {
        return dimensionsWeightRepository.findById(id)
                .map(dimensionsWeightMapper::toDimensionsWeightDTO)
                .orElseThrow(()-> new RuntimeException("Items with current Id not found"));
    }
}
