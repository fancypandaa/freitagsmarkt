package auto.freitagsmarkt.controller.specs;

import auto.freitagsmarkt.domain.enums.ChassisType;
import auto.freitagsmarkt.dto.specs.InteriorDTO;
import auto.freitagsmarkt.dto.specs.InteriorDTO;
import auto.freitagsmarkt.service.specs.InteriorService;
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

class InteriorControllerTest {
    private static final String MAIN_URI ="/api/interior";
    private MockMvc mockMvc;
    private InteriorService interiorService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        interiorService = Mockito.mock(InteriorService.class);
        objectMapper = new ObjectMapper();
        InteriorController interiorController = new InteriorController(interiorService);
        mockMvc = MockMvcBuilders.standaloneSetup(interiorController).build();
    }

    @Test
    void addNewInterior() throws Exception{
        InteriorDTO interiorDTO = InteriorDTO.builder().interiorId(1L)
                .connectivity("{\"Radio\":\"Yes\"}")
                .climateControl("{\"ClimateControl\":\"Automatic\"}")
                .displays("{\"CenterDisplay\":\"Yes\"}")
                .speakers("{\"TotalNumberOfSpeakers\":\"4 pcs\"}")
                .interiorStorage("{\"StorageCompartments\":\"{\"Glove Compartment\":\"Cooled | Light | Lockable (Manual)\"}\"}").build();
        when(interiorService.createInterior(any(InteriorDTO.class))).thenReturn(interiorDTO);
        String url = String.format("%s", MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(interiorDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.connectivity").value(is("{\"Radio\":\"Yes\"}")))
                .andExpect(jsonPath("$.climateControl").value(is("{\"ClimateControl\":\"Automatic\"}")))
                .andExpect(jsonPath("$.displays").value(is("{\"CenterDisplay\":\"Yes\"}")));
    }

    @Test
    void findInteriorId() throws Exception {
        when(interiorService.findInteriorById(anyLong())).thenReturn(
                InteriorDTO.builder().interiorId(1L)
                        .connectivity("{\"Radio\":\"Yes\"}")
                        .climateControl("{\"ClimateControl\":\"Automatic\"}")
                        .displays("{\"CenterDisplay\":\"Yes\"}")
                        .speakers("{\"TotalNumberOfSpeakers\":\"4 pcs\"}")
                        .interiorStorage("{\"StorageCompartments\":\"{\"Glove Compartment\":\"Cooled | Light | Lockable (Manual)\"}\"}").build()
        );
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.climateControl").value(is("{\"ClimateControl\":\"Automatic\"}")))
                .andExpect(jsonPath("$.displays").value(is("{\"CenterDisplay\":\"Yes\"}")));
    }
}