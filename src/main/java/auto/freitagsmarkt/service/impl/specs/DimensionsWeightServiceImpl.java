package auto.freitagsmarkt.service.impl.specs;


import auto.freitagsmarkt.dto.specs.DimensionsWeightDTO;
import auto.freitagsmarkt.mapper.specs.DimensionsWeightMapper;
import auto.freitagsmarkt.repository.specs.DimensionsWeightRepository;
import auto.freitagsmarkt.service.specs.DimensionsWeightService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DimensionsWeightServiceImpl implements DimensionsWeightService {

    private DimensionsWeightMapper dimensionsWeightMapper;
    private DimensionsWeightRepository dimensionsWeightRepository;

    public DimensionsWeightServiceImpl(DimensionsWeightMapper dimensionsWeightMapper,
                                       DimensionsWeightRepository dimensionsWeightRepository) {
        this.dimensionsWeightMapper = dimensionsWeightMapper;
        this.dimensionsWeightRepository = dimensionsWeightRepository;
    }

    @Override
    public DimensionsWeightDTO addNewDimAndWeight(DimensionsWeightDTO dimensionsWeightDTO) {
        return Optional.ofNullable(dimensionsWeightDTO)
                .map(dimensionsWeightMapper::toDimensionWeight)
                .map(dimensionsWeightRepository::save)
                .map(dimensionsWeightMapper::toDimensionsWeightDTO)
                .orElseThrow(() -> new RuntimeException("Cannot create DimensionsWeight"));
    }

    @Override
    public DimensionsWeightDTO findDimensionsAndWeighById(Long id) {
        return dimensionsWeightRepository.findById(id)
                .map(dimensionsWeightMapper::toDimensionsWeightDTO)
                .orElseThrow(()-> new RuntimeException("DimensionsAndWeigh for current Id not found"));
    }
}
