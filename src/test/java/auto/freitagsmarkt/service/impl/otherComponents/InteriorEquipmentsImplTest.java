package auto.freitagsmarkt.service.impl.otherComponents;


import auto.freitagsmarkt.domain.othersComponents.InteriorEquipments;
import auto.freitagsmarkt.dto.components.InteriorEquipmentsDTO;
import auto.freitagsmarkt.mapper.components.InteriorEquipmentsMapper;
import auto.freitagsmarkt.repository.components.InteriorEquipmentsRepository;
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
class InteriorEquipmentsImplTest {
    @Mock
    private InteriorEquipmentsRepository interiorEquipmentsRepository;
    @Mock
    private InteriorEquipmentsMapper interiorEquipmentsMapper;
    @InjectMocks
    private InteriorEquipmentsImpl interiorEquipmentsService;
    private InteriorEquipments interiorEquipments;
    private InteriorEquipmentsDTO interiorEquipmentsDTO;
    @BeforeEach
    void setUp() {
        interiorEquipments = new InteriorEquipments();
        interiorEquipmentsDTO =InteriorEquipmentsDTO.builder().build();
    }

    @Test
    void createNewInteriorEquipments_success() {
        when(interiorEquipmentsMapper.toInteriorEquipments(any())).thenReturn(interiorEquipments);
        when(interiorEquipmentsRepository.save(any())).thenReturn(interiorEquipments);
        when(interiorEquipmentsMapper.toInteriorEquipmentsDTO(any())).thenReturn(interiorEquipmentsDTO);
        InteriorEquipmentsDTO savedAd = interiorEquipmentsService.createNewInteriorEquipment(interiorEquipmentsDTO);
        assertNotNull(savedAd);
        verify(interiorEquipmentsRepository,times(1)).save(any());
        verify(interiorEquipmentsMapper,times(1)).toInteriorEquipments(interiorEquipmentsDTO);
    }
    @Test
    void createNewInteriorEquipments_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> interiorEquipmentsService.createNewInteriorEquipment(null));
        assertEquals("Interior - Equipment not created!!",exception.getMessage());
    }
    @Test
    void findInteriorEquipmentsById_success() {
        when(interiorEquipmentsRepository.findById(anyLong())).thenReturn(Optional.of(interiorEquipments));
        when(interiorEquipmentsMapper.toInteriorEquipmentsDTO(any())).thenReturn(interiorEquipmentsDTO);
        InteriorEquipmentsDTO savedInteriorEquipmentsDTO = interiorEquipmentsService.findInteriorEquipmentById(1L);
        assertNotNull(savedInteriorEquipmentsDTO);
        verify(interiorEquipmentsRepository,times(1)).findById(1L);
    }
    @Test
    void findInteriorEquipmentsById_notFound() {
        when(interiorEquipmentsRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> interiorEquipmentsService.findInteriorEquipmentById(anyLong()));
        assertEquals("Interior-Equipment not found",exception.getMessage());
    }
}