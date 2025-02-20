package auto.freitagsmarkt.controller.otherComponents;

import auto.freitagsmarkt.dto.components.InteriorEquipmentsDTO;
import auto.freitagsmarkt.service.impl.otherComponents.InteriorEquipmentsImpl;
import auto.freitagsmarkt.service.otherComponents.InteriorEquipmentsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class InteriorEquipmentsControllerTest {

    private static final String MAIN_URI ="/api/interiorEquipments";
    private MockMvc mockMvc;
    private InteriorEquipmentsImpl interiorEquipmentsService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        interiorEquipmentsService = Mockito.mock(InteriorEquipmentsImpl.class);
        objectMapper = new ObjectMapper();
        InteriorEquipmentsController interiorEquipmentsController = new InteriorEquipmentsController(interiorEquipmentsService);
        mockMvc = MockMvcBuilders.standaloneSetup(interiorEquipmentsController).build();
    }
    @Test
    void addNewInteriorEquipments() throws Exception{
        InteriorEquipmentsDTO interiorEquipmentsDTO = InteriorEquipmentsDTO.builder().id(1L)
                .trunk("{\"TotalTrunkVolume\":\"444 l\"}")
                .rimsTires("{\"BoltDistance\":\"108\"}")
                .seats("{\"General\":{\"NumberOfSeats\":\"5\"}}")
                .design("{\"Pedals\":\"Sport\"}").build();
        when(interiorEquipmentsService.createNewInteriorEquipment(any(InteriorEquipmentsDTO.class))).thenReturn(interiorEquipmentsDTO);
        String url = String.format("%s", MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(interiorEquipmentsDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.trunk").value(is("{\"TotalTrunkVolume\":\"444 l\"}")))
                .andExpect(jsonPath("$.rimsTires").value(is("{\"BoltDistance\":\"108\"}")))
                .andExpect(jsonPath("$.seats").value(is("{\"General\":{\"NumberOfSeats\":\"5\"}}")));
    }

    @Test
    void findInteriorEquipmentsId() throws Exception {
        when(interiorEquipmentsService.findInteriorEquipmentById(anyLong())).thenReturn(
                InteriorEquipmentsDTO.builder().id(1L)
                        .trunk("{\"TotalTrunkVolume\":\"444 l\"}")
                        .rimsTires("{\"BoltDistance\":\"108\"}")
                        .seats("{\"General\":{\"NumberOfSeats\":\"5\"}}")
                        .design("{\"Pedals\":\"Sport\"}").build()
        );
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trunk").value(is("{\"TotalTrunkVolume\":\"444 l\"}")))
                .andExpect(jsonPath("$.rimsTires").value(is("{\"BoltDistance\":\"108\"}")));
    }

}