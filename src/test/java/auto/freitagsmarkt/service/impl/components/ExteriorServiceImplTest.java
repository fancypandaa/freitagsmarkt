package auto.freitagsmarkt.service.impl.components;


import auto.freitagsmarkt.domain.components.Exterior;
import auto.freitagsmarkt.dto.components.ExteriorDTO;
import auto.freitagsmarkt.mapper.components.ExteriorMapper;
import auto.freitagsmarkt.repository.components.ExteriorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExteriorServiceImplTest {

    @Mock
    private ExteriorRepository exteriorRepository;
    @Mock
    private ExteriorMapper exteriorMapper;
    @InjectMocks
    private ExteriorServiceImpl exteriorService;
    private Exterior exterior;
    private ExteriorDTO exteriorDTO;
    @BeforeEach
    void setUp() {
        exterior = new Exterior();
        exteriorDTO =ExteriorDTO.builder().build();
    }


    @Test
    void createNewExterior_success() {
        when(exteriorMapper.toExterior(any())).thenReturn(exterior);
        when(exteriorRepository.save(any())).thenReturn(exterior);
        when(exteriorMapper.toExteriorDTO(any())).thenReturn(exteriorDTO);
        ExteriorDTO savedAd = exteriorService.createExterior(exteriorDTO);
        assertNotNull(savedAd);
        verify(exteriorRepository,times(1)).save(any());
        verify(exteriorMapper,times(1)).toExterior(exteriorDTO);
    }
    @Test
    void createNewAd_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> exteriorService.createExterior(null));
        assertEquals("Exterior not created",exception.getMessage());
    }

    @Test
    void findExteriorById_success() {
        when(exteriorRepository.findById(anyLong())).thenReturn(Optional.of(exterior));
        when(exteriorMapper.toExteriorDTO(any())).thenReturn(exteriorDTO);
        ExteriorDTO savedExteriorDTO = exteriorService.findByExteriorId(1L);
        assertNotNull(savedExteriorDTO);
        verify(exteriorRepository,times(1)).findById(1L);
    }
    @Test
    void findExteriorById_notFound() {
        when(exteriorRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> exteriorService.findByExteriorId(anyLong()));
        assertEquals("Exterior not found",exception.getMessage());
    }
}