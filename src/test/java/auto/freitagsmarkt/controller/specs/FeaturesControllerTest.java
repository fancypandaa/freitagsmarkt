package auto.freitagsmarkt.controller.specs;

import auto.freitagsmarkt.dto.specs.FeaturesDTO;
import auto.freitagsmarkt.service.specs.FeaturesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FeaturesControllerTest {
    private static final String MAIN_URI ="/api/features";
    private MockMvc mockMvc;
    private FeaturesService featuresService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        featuresService = Mockito.mock(FeaturesService.class);
        objectMapper = new ObjectMapper();
        FeaturesController featuresController = new FeaturesController(featuresService);
        mockMvc = MockMvcBuilders.standaloneSetup(featuresController).build();
    }
    @Test
    void addNewFeatures() throws Exception {
        FeaturesDTO featuresDTO = FeaturesDTO.builder().featuresId(1L)
                .comfort("{\"CruiseControl\":\"Yes\",\"Cameras\":\"Front | Sides | Rear\"}")
                .accessories("{\"TireRepairKit\":\"Yes\"}")
                .others("{\"Start&Stop\":\"Yes\",\"NoiseLevelDriving\":\"68 dB\"}").build();
        when(featuresService.addNewCarFeatures(any(FeaturesDTO.class))).thenReturn(featuresDTO);
        String url = String.format("%s", MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(featuresDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.comfort").value(is("{\"CruiseControl\":\"Yes\",\"Cameras\":\"Front | Sides | Rear\"}")))
                .andExpect(jsonPath("$.accessories").value(is("{\"TireRepairKit\":\"Yes\"}")))
                .andExpect(jsonPath("$.others").value(is("{\"Start&Stop\":\"Yes\",\"NoiseLevelDriving\":\"68 dB\"}")));
    }

    @Test
    void findFeaturesById() throws Exception {
        when(featuresService.findFeaturesById(anyLong())).thenReturn(
                FeaturesDTO.builder().featuresId(1L)
                        .comfort("{\"CruiseControl\":\"Yes\",\"Cameras\":\"Front | Sides | Rear\"}")
                        .accessories("{\"TireRepairKit\":\"Yes\"}")
                        .others("{\"Start&Stop\":\"Yes\",\"NoiseLevelDriving\":\"68 dB\"}").build()
        );
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accessories").value(is("{\"TireRepairKit\":\"Yes\"}")))
                .andExpect(jsonPath("$.others").value(is("{\"Start&Stop\":\"Yes\",\"NoiseLevelDriving\":\"68 dB\"}")));
    }
}