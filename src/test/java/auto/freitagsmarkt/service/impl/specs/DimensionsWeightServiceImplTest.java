package auto.freitagsmarkt.service.impl.specs;

import auto.freitagsmarkt.domain.specs.DimensionsWeight;
import auto.freitagsmarkt.dto.specs.DimensionsWeightDTO;
import auto.freitagsmarkt.mapper.specs.DimensionsWeightMapper;
import auto.freitagsmarkt.repository.specs.DimensionsWeightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DimensionsWeightServiceImplTest {
    @Mock
    private DimensionsWeightRepository dimensionsWeightRepository;
    @Mock
    private DimensionsWeightMapper dimensionsWeightMapper;
    @InjectMocks
    private DimensionsWeightServiceImpl dimensionsWeightService;
    private DimensionsWeight dimensionsWeight;
    private DimensionsWeightDTO dimensionsWeightDTO;
    
    @BeforeEach
    void setUp() {
        dimensionsWeight = new DimensionsWeight();
        dimensionsWeightDTO= DimensionsWeightDTO.builder().build();
    }

    @Test
    void createNewDimensionsWeight_success() {
        when(dimensionsWeightMapper.toDimensionWeight(any())).thenReturn(dimensionsWeight);
        when(dimensionsWeightRepository.save(any())).thenReturn(dimensionsWeight);
        when(dimensionsWeightMapper.toDimensionsWeightDTO(any())).thenReturn(dimensionsWeightDTO);
        DimensionsWeightDTO saveDimensionsWeight = dimensionsWeightService.addNewDimAndWeight(dimensionsWeightDTO);
        assertNotNull(saveDimensionsWeight);
        verify(dimensionsWeightRepository,times(1)).save(any());
        verify(dimensionsWeightMapper,times(1)).toDimensionWeight(dimensionsWeightDTO);
    }
    @Test
    void createNewDimensionsWeight_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> dimensionsWeightService.addNewDimAndWeight(null));
        assertEquals("Cannot create DimensionsWeight",exception.getMessage());
    }
    @Test
    void findDimensionsWeightById_success() {
        when(dimensionsWeightRepository.findById(anyLong())).thenReturn(Optional.of(dimensionsWeight));
        when(dimensionsWeightMapper.toDimensionsWeightDTO(any())).thenReturn(dimensionsWeightDTO);
        DimensionsWeightDTO savedDimensionsWeightDTO = dimensionsWeightService.findDimensionsAndWeighById(1L);
        assertNotNull(savedDimensionsWeightDTO);
        verify(dimensionsWeightRepository,times(1)).findById(1L);
    }
    @Test
    void findDimensionsWeightById_notFound() {
        when(dimensionsWeightRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> dimensionsWeightService.findDimensionsAndWeighById(anyLong()));
        assertEquals("DimensionsAndWeigh for current Id not found",exception.getMessage());
    }
}