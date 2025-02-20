package auto.freitagsmarkt.service.impl.specs;

import auto.freitagsmarkt.domain.specs.Features;
import auto.freitagsmarkt.dto.specs.FeaturesDTO;
import auto.freitagsmarkt.mapper.specs.FeaturesMapper;
import auto.freitagsmarkt.repository.specs.FeaturesRepository;
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
class FeaturesServiceImplTest {
    @Mock
    private FeaturesRepository featuresRepository;
    @Mock
    private FeaturesMapper featuresMapper;
    @InjectMocks
    private FeaturesServiceImpl featuresService;
    private Features features;
    private FeaturesDTO featuresDTO;
    @BeforeEach
    void setUp() {
        features = new Features();
        featuresDTO =FeaturesDTO.builder().build();
    }


    @Test
    void createNewFeatures_success() {
        when(featuresMapper.toFeatures(any())).thenReturn(features);
        when(featuresRepository.save(any())).thenReturn(features);
        when(featuresMapper.toFeaturesDTO(any())).thenReturn(featuresDTO);
        FeaturesDTO savedAd = featuresService.addNewCarFeatures(featuresDTO);
        assertNotNull(savedAd);
        verify(featuresRepository,times(1)).save(any());
        verify(featuresMapper,times(1)).toFeatures(featuresDTO);
    }
    @Test
    void createNewFeatures_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> featuresService.addNewCarFeatures(null));
        assertEquals("Cannot create New car feature",exception.getMessage());
    }

    @Test
    void findFeaturesById_success() {
        when(featuresRepository.findById(anyLong())).thenReturn(Optional.of(features));
        when(featuresMapper.toFeaturesDTO(any())).thenReturn(featuresDTO);
        FeaturesDTO savedFeaturesDTO = featuresService.findFeaturesById(1L);
        assertNotNull(savedFeaturesDTO);
        verify(featuresRepository,times(1)).findById(1L);
    }
    @Test
    void findFeaturesById_notFound() {
        when(featuresRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> featuresService.findFeaturesById(anyLong()));
        assertEquals("Feature not found",exception.getMessage());
    }
}