package auto.freitagsmarkt.controller.specs;


import auto.freitagsmarkt.dto.specs.DimensionsWeightDTO;
import auto.freitagsmarkt.service.specs.DimensionsWeightService;
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

class DimensionsWeightControllerTest {
    private static final String MAIN_URI ="/api/dimensionsWeight";
    private MockMvc mockMvc;
    private DimensionsWeightService dimensionsWeightService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        dimensionsWeightService = Mockito.mock(DimensionsWeightService.class);
        objectMapper = new ObjectMapper();
        DimensionsWeightController dimensionsWeightController = new DimensionsWeightController(dimensionsWeightService);
        mockMvc = MockMvcBuilders.standaloneSetup(dimensionsWeightController).build();
    }
    @Test
    void findDimAndWeightById() throws Exception {
        DimensionsWeightDTO dimensionsWeightDTO =   DimensionsWeightDTO.builder().dimId(1L)
                .exterior("{\"Length\":\"4,959 mm\",\"Width\":\"1,920 mm\"}")
                .interior("{\"Ground Clearance\":\"175 - 200 mm\",\"Overhang\":\"881 mm\"}")
                .lcvSpecific("{\"Version\":\"L1H1 | L2H1 | L3H1 \"}")
                .weight("{\"Curb Weight\":\"1,890 kg\"}")
                .build();
        when(dimensionsWeightService.findDimensionsAndWeighById(anyLong())).thenReturn(dimensionsWeightDTO);
        String url = String.format("%s/%s",MAIN_URI,anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.exterior",is("{\"Length\":\"4,959 mm\",\"Width\":\"1,920 mm\"}")))
                .andExpect(jsonPath("$.interior",is("{\"Ground Clearance\":\"175 - 200 mm\",\"Overhang\":\"881 mm\"}")));
    }

    @Test
    void addNewCarDimensionAndWeight() throws Exception {
        DimensionsWeightDTO dimensionsWeightDTO =   DimensionsWeightDTO.builder().dimId(1L)
                .exterior("{\"Length\":\"4,959 mm\",\"Width\":\"1,920 mm\"}")
                .interior("{\"Ground Clearance\":\"175 - 200 mm\",\"Overhang\":\"881 mm\"}")
                .lcvSpecific("{\"Version\":\"L1H1 | L2H1 | L3H1 \"}")
                .weight("{\"Curb Weight\":\"1,890 kg\"}")
                .build();
        when(dimensionsWeightService.addNewDimAndWeight(any(DimensionsWeightDTO.class))).thenReturn(dimensionsWeightDTO);
        String url = String.format("%s",MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(dimensionsWeightDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.exterior",is("{\"Length\":\"4,959 mm\",\"Width\":\"1,920 mm\"}")))
                .andExpect(jsonPath("$.interior",is("{\"Ground Clearance\":\"175 - 200 mm\",\"Overhang\":\"881 mm\"}")));

    }
}