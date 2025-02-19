package auto.freitagsmarkt.service.impl.specs;


import auto.freitagsmarkt.domain.specs.Engine;
import auto.freitagsmarkt.dto.specs.EngineDTO;
import auto.freitagsmarkt.mapper.specs.EngineMapper;
import auto.freitagsmarkt.repository.specs.EngineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EngineServiceImplTest {
    @Mock
    private EngineRepository engineRepository;
    @Mock
    private EngineMapper engineMapper;
    @InjectMocks
    private EngineServiceImpl engineService;
    private Engine engine;
    private EngineDTO engineDTO;
    @BeforeEach
    void setUp() {
        engine = new Engine();
        engineDTO =EngineDTO.builder().build();
    }

    @Test
    void listAllEngine_whenNoEngineExist() {
        when(engineRepository.findAll(any(PageRequest.class))).thenReturn(Page.empty());
        List<EngineDTO> engineDTOList = engineService.listEngines(0,10);
        assertTrue(engineDTOList.isEmpty());
        verify(engineRepository,times(1)).findAll(any(PageRequest.class));
    }
    @Test
    void listAllEngine_whenEngineExist() {
        when(engineRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(engine)));
        when(engineMapper.engineListDTO(anyList())).thenReturn(List.of(engineDTO));
        List<EngineDTO> engineDTOs = engineService.listEngines(0,5);
        assertFalse(engineDTOs.isEmpty());
        verify(engineRepository,times(1)).findAll(any(PageRequest.class));
        verify(engineMapper,times(1)).engineListDTO(anyList());
    }
    @Test
    void listAllEngine_whenEngineExist_wrongPage() {
        when(engineRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(engine)));
        List<EngineDTO> engineDTOs = engineService.listEngines(2,5);
        assertTrue(engineDTOs.isEmpty());
        verify(engineRepository,times(1)).findAll(any(PageRequest.class));
    }
    @Test
    void createNewEngine_success() {
        when(engineMapper.toEngine(any())).thenReturn(engine);
        when(engineRepository.save(any())).thenReturn(engine);
        when(engineMapper.toEngineDTO(any())).thenReturn(engineDTO);
        EngineDTO savedEngine = engineService.addNewEngineDetails(engineDTO);
        assertNotNull(savedEngine);
        verify(engineRepository,times(1)).save(any());
        verify(engineMapper,times(1)).toEngine(engineDTO);
    }
    @Test
    void createNewEngine_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> engineService.addNewEngineDetails(null));
        assertEquals("Engine cannot created",exception.getMessage());
    }
    @Test
    void findEngineById_success() {
        when(engineRepository.findById(anyLong())).thenReturn(Optional.of(engine));
        when(engineMapper.toEngineDTO(any())).thenReturn(engineDTO);
        EngineDTO savedEngineDTO = engineService.findEngineById(1L);
        assertNotNull(savedEngineDTO);
        verify(engineRepository,times(1)).findById(1L);
    }
    @Test
    void findEngineById_notFound() {
        when(engineRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> engineService.findEngineById(anyLong()));
        assertEquals("Engine Not Found",exception.getMessage());
    }
    @Test
    void removeEngineById_Success() {
        when(engineRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(engineRepository).deleteById(anyLong());
        Boolean ans = engineService.removeEngineById(anyLong());
        assertTrue(ans);
        verify(engineRepository,times(1)).deleteById(anyLong());
    }
    @Test
    void removeEngineById_notFound() {
        when(engineRepository.existsById(anyLong())).thenReturn(false);
        Boolean ans = engineService.removeEngineById(anyLong());
        assertFalse(ans);
    }
}