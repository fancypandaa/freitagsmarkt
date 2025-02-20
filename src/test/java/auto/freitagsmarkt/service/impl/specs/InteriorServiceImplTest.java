package auto.freitagsmarkt.service.impl.specs;

import auto.freitagsmarkt.domain.specs.Interior;
import auto.freitagsmarkt.dto.specs.InteriorDTO;
import auto.freitagsmarkt.mapper.specs.InteriorMapper;
import auto.freitagsmarkt.repository.specs.InteriorRepository;
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
class InteriorServiceImplTest {

    @Mock
    private InteriorRepository interiorRepository;
    @Mock
    private InteriorMapper interiorMapper;
    @InjectMocks
    private InteriorServiceImpl interiorService;
    private Interior interior;
    private InteriorDTO interiorDTO;
    @BeforeEach
    void setUp() {
        interior = new Interior();
        interiorDTO =InteriorDTO.builder().build();
    }


    @Test
    void createNewInterior_success() {
        when(interiorMapper.toInterior(any())).thenReturn(interior);
        when(interiorRepository.save(any())).thenReturn(interior);
        when(interiorMapper.toInteriorDTO(any())).thenReturn(interiorDTO);
        InteriorDTO savedAd = interiorService.createInterior(interiorDTO);
        assertNotNull(savedAd);
        verify(interiorRepository,times(1)).save(any());
        verify(interiorMapper,times(1)).toInterior(interiorDTO);
    }
    @Test
    void createNewAd_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> interiorService.createInterior(null));
        assertEquals("Interior not created!",exception.getMessage());
    }

    @Test
    void findInteriorById_success() {
        when(interiorRepository.findById(anyLong())).thenReturn(Optional.of(interior));
        when(interiorMapper.toInteriorDTO(any())).thenReturn(interiorDTO);
        InteriorDTO savedInteriorDTO = interiorService.findInteriorById(1L);
        assertNotNull(savedInteriorDTO);
        verify(interiorRepository,times(1)).findById(1L);
    }
    @Test
    void findInteriorById_notFound() {
        when(interiorRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> interiorService.findInteriorById(anyLong()));
        assertEquals("Interior Not found",exception.getMessage());
    }
}