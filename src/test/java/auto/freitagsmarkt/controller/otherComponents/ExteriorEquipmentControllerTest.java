package auto.freitagsmarkt.controller.otherComponents;

import auto.freitagsmarkt.domain.enums.AdsStatus;
import auto.freitagsmarkt.dto.components.ExteriorEquipmentDTO;
import auto.freitagsmarkt.dto.components.ExteriorEquipmentDTO;
import auto.freitagsmarkt.service.otherComponents.ExteriorEquipmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ExteriorEquipmentControllerTest {

    private static final String MAIN_URI ="/api/exteriorEquipment";
    private MockMvc mockMvc;
    private ExteriorEquipmentService exteriorEquipmentService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        exteriorEquipmentService = Mockito.mock(ExteriorEquipmentService.class);
        objectMapper = new ObjectMapper();
        ExteriorEquipmentController equipmentController = new ExteriorEquipmentController(exteriorEquipmentService);
        mockMvc = MockMvcBuilders.standaloneSetup(equipmentController).build();
    }

    @Test
    void getExteriorEquipment() throws Exception {
        ExteriorEquipmentDTO exteriorEquipmentDTO = ExteriorEquipmentDTO.builder().exEquipmentId(1L)
                .roofColour("{\"TotalTrunkVolume\":\"444 l\"}")
                .tireDimensions("{\"BoltDistance\":\"108\"}")
                .doorHandles("{\"General\":{\"NumberOfSeats\":\"5\"}}")
                .rimsAndTires("{\"Pedals\":\"Sport\"}").build();
        when(exteriorEquipmentService.findExteriorEquipmentById(anyLong())).thenReturn(exteriorEquipmentDTO);
        String url = String.format("%s/%s", MAIN_URI,anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roofColour").value(is("{\"TotalTrunkVolume\":\"444 l\"}")))
                .andExpect(jsonPath("$.doorHandles").value(is("{\"General\":{\"NumberOfSeats\":\"5\"}}")));    }

    @Test
    void createNewExteriorEquipment() throws Exception{
        ExteriorEquipmentDTO exteriorEquipmentDTO = ExteriorEquipmentDTO.builder().exEquipmentId(1L)
                .roofColour("{\"TotalTrunkVolume\":\"444 l\"}")
                .tireDimensions("{\"BoltDistance\":\"108\"}")
                .doorHandles("{\"General\":{\"NumberOfSeats\":\"5\"}}")
                .rimsAndTires("{\"Pedals\":\"Sport\"}").build();
        when(exteriorEquipmentService.createExteriorEquipment(any(ExteriorEquipmentDTO.class))).thenReturn(exteriorEquipmentDTO);
        String url = String.format("%s", MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(exteriorEquipmentDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.roofColour").value(is("{\"TotalTrunkVolume\":\"444 l\"}")))
                .andExpect(jsonPath("$.tireDimensions").value(is("{\"BoltDistance\":\"108\"}")))
                .andExpect(jsonPath("$.doorHandles").value(is("{\"General\":{\"NumberOfSeats\":\"5\"}}")));
    }
}