package auto.freitagsmarkt.service.impl.otherComponents;

import auto.freitagsmarkt.domain.othersComponents.ExteriorEquipment;
import auto.freitagsmarkt.dto.components.ExteriorEquipmentDTO;
import auto.freitagsmarkt.mapper.components.ExteriorEquipmentMapper;
import auto.freitagsmarkt.repository.components.ExteriorEquipmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ExteriorEquipmentServiceImplTest {
    @Mock
    private ExteriorEquipmentRepository exteriorEquipmentsRepository;
    @Mock
    private ExteriorEquipmentMapper exteriorEquipmentsMapper;
    @InjectMocks
    private ExteriorEquipmentServiceImpl exteriorEquipmentsService;
    private ExteriorEquipment exteriorEquipments;
    private ExteriorEquipmentDTO exteriorEquipmentsDTO;
    @BeforeEach
    void setUp() {
        exteriorEquipments = new ExteriorEquipment();
        exteriorEquipmentsDTO =ExteriorEquipmentDTO.builder().build();
    }

    @Test
    void createNewExteriorEquipment_success() {
        when(exteriorEquipmentsMapper.toExteriorEquipment(any())).thenReturn(exteriorEquipments);
        when(exteriorEquipmentsRepository.save(any())).thenReturn(exteriorEquipments);
        when(exteriorEquipmentsMapper.toExteriorEquipmentDTO(any())).thenReturn(exteriorEquipmentsDTO);
        ExteriorEquipmentDTO savedAd = exteriorEquipmentsService.createExteriorEquipment(exteriorEquipmentsDTO);
        assertNotNull(savedAd);
        verify(exteriorEquipmentsRepository,times(1)).save(any());
        verify(exteriorEquipmentsMapper,times(1)).toExteriorEquipment(exteriorEquipmentsDTO);
    }
    @Test
    void createNewExteriorEquipment_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> exteriorEquipmentsService.createExteriorEquipment(null));
        assertEquals("Exterior equipment cannot created!",exception.getMessage());
    }
    @Test
    void findExteriorEquipmentById_success() {
        when(exteriorEquipmentsRepository.findById(anyLong())).thenReturn(Optional.of(exteriorEquipments));
        when(exteriorEquipmentsMapper.toExteriorEquipmentDTO(any())).thenReturn(exteriorEquipmentsDTO);
        ExteriorEquipmentDTO savedExteriorEquipmentDTO = exteriorEquipmentsService.findExteriorEquipmentById(1L);
        assertNotNull(savedExteriorEquipmentDTO);
        verify(exteriorEquipmentsRepository,times(1)).findById(1L);
    }
    @Test
    void findExteriorEquipmentById_notFound() {
        when(exteriorEquipmentsRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> exteriorEquipmentsService.findExteriorEquipmentById(anyLong()));
        assertEquals("Exterior Equipment not found",exception.getMessage());
    }
}