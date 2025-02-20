package auto.freitagsmarkt.service.impl.specs;

import auto.freitagsmarkt.domain.specs.SafetyAndSecurity;
import auto.freitagsmarkt.dto.specs.SafetyAndSecurityDTO;
import auto.freitagsmarkt.mapper.specs.SafetyAndSecurityMapper;
import auto.freitagsmarkt.repository.specs.SafetyAndSecurityRepository;
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
class SafetyAndSecurityServiceImplTest {
    @Mock
    private SafetyAndSecurityRepository safetyAndSecurityRepository;
    @Mock
    private SafetyAndSecurityMapper safetyAndSecurityMapper;
    @InjectMocks
    private SafetyAndSecurityServiceImpl safetyAndSecurityService;
    private SafetyAndSecurity safetyAndSecurity;
    private SafetyAndSecurityDTO safetyAndSecurityDTO;
    @BeforeEach
    void setUp() {
        safetyAndSecurity = new SafetyAndSecurity();
        safetyAndSecurityDTO =SafetyAndSecurityDTO.builder().build();
    }


    @Test
    void createNewSafetyAndSecurity_success() {
        when(safetyAndSecurityMapper.toSafetyAndSecurity(any())).thenReturn(safetyAndSecurity);
        when(safetyAndSecurityRepository.save(any())).thenReturn(safetyAndSecurity);
        when(safetyAndSecurityMapper.toSafetyAndSecurityDTO(any())).thenReturn(safetyAndSecurityDTO);
        SafetyAndSecurityDTO savedAd = safetyAndSecurityService.addNewSafetyAndSecurity(safetyAndSecurityDTO);
        assertNotNull(savedAd);
        verify(safetyAndSecurityRepository,times(1)).save(any());
        verify(safetyAndSecurityMapper,times(1)).toSafetyAndSecurity(safetyAndSecurityDTO);
    }
    @Test
    void createNewAd_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> safetyAndSecurityService.addNewSafetyAndSecurity(null));
        assertEquals("failed to create SafetyAndSecurity new Item",exception.getMessage());
    }

    @Test
    void findSafetyAndSecurityById_success() {
        when(safetyAndSecurityRepository.findById(anyLong())).thenReturn(Optional.of(safetyAndSecurity));
        when(safetyAndSecurityMapper.toSafetyAndSecurityDTO(any())).thenReturn(safetyAndSecurityDTO);
        SafetyAndSecurityDTO savedSafetyAndSecurityDTO = safetyAndSecurityService.findBySafetyAndSecurityId(1L);
        assertNotNull(savedSafetyAndSecurityDTO);
        verify(safetyAndSecurityRepository,times(1)).findById(1L);
    }
    @Test
    void findSafetyAndSecurityById_notFound() {
        when(safetyAndSecurityRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> safetyAndSecurityService.findBySafetyAndSecurityId(anyLong()));
        assertEquals("safety And security item not found",exception.getMessage());
    }
}