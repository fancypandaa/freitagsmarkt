package auto.freitagsmarkt.controller.specs;


import auto.freitagsmarkt.dto.specs.EngineDTO;
import auto.freitagsmarkt.service.specs.EngineService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EngineControllerTest {
    private static final String MAIN_URI ="/api/engine";
    private MockMvc mockMvc;
    private EngineService engineService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {

        engineService = Mockito.mock(EngineService.class);
        objectMapper = new ObjectMapper();
        EngineController engineController = new EngineController(engineService);
        mockMvc = MockMvcBuilders.standaloneSetup(engineController).build();
    }

    @Test
    void listAllEngine() throws Exception {
        List<EngineDTO> engineDTOList= Arrays.asList(
                EngineDTO.builder().engineId(1L)
                        .engineSpecification("{\"Power\":\"88 kW\",\"Horsepower\":\"120 hp (118 bhp)\"}")
                        .engineConfiguration("{\"Displacement\":\"1,499 cc / 1.5 l\",\"Engine Configuration\":\"Inline\",\"Fuel System\":\"Fuel Injection \"}")
                        .engineFluids("{\"SyntheticOil_viscosity\":\"0W-30\"}")
                        .build(),
                EngineDTO.builder().engineId(1L)
                        .engineSpecification("{\"Power\":\"90 kW\",\"Horsepower\":\"125 hp (118 bhp)\"}")
                        .engineConfiguration("{\"Displacement\":\"1,499 cc / 1.5 l\",\"Engine Configuration\":\"Inline\",\"Fuel System\":\"Fuel Injection \"}")
                        .engineFluids("{\"SyntheticOil_viscosity\":\"0W-35\"}")
                        .build()

                );
        String url = String.format("%s/all-engines", MAIN_URI,1L);

        when(engineService.listEngines(0,10)).thenReturn(engineDTOList);
        mockMvc.perform(get(url)
                        .param("page","0")
                        .param("size","10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",is(2)))
                .andExpect(jsonPath("$[0].engineFluids",is("{\"SyntheticOil_viscosity\":\"0W-30\"}")));
    }

    @Test
    void findEngineById() throws Exception {
        EngineDTO engineDTO =   EngineDTO.builder().engineId(1L)
                .engineSpecification("{\"Power\":\"88 kW\",\"Horsepower\":\"120 hp (118 bhp)\"}")
                .engineConfiguration("{\"Displacement\":\"1,499 cc / 1.5 l\",\"Engine Configuration\":\"Inline\",\"Fuel System\":\"Fuel Injection \"}")
                .engineFluids("{\"SyntheticOil_viscosity\":\"0W-30\"}")
                .build();
        when(engineService.findEngineById(anyLong())).thenReturn(engineDTO);
        String url = String.format("%s/%s",MAIN_URI,anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.engineSpecification",is("{\"Power\":\"88 kW\",\"Horsepower\":\"120 hp (118 bhp)\"}")))
                .andExpect(jsonPath("$.engineFluids",is("{\"SyntheticOil_viscosity\":\"0W-30\"}")));
    }

    @Test
    void addNewEngine() throws Exception {
        EngineDTO engineDTO =   EngineDTO.builder().engineId(1L)
                .engineSpecification("{\"Power\":\"88 kW\",\"Horsepower\":\"120 hp (118 bhp)\"}")
                .engineConfiguration("{\"Displacement\":\"1,499 cc / 1.5 l\",\"Engine Configuration\":\"Inline\",\"Fuel System\":\"Fuel Injection \"}")
                .engineFluids("{\"SyntheticOil_viscosity\":\"0W-30\"}")
                .build();
        when(engineService.addNewEngineDetails(any(EngineDTO.class))).thenReturn(engineDTO);
        String url = String.format("%s",MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(engineDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.engineSpecification",is("{\"Power\":\"88 kW\",\"Horsepower\":\"120 hp (118 bhp)\"}")))
                .andExpect(jsonPath("$.engineFluids",is("{\"SyntheticOil_viscosity\":\"0W-30\"}")));
    }

    @Test
    void deleteEngineById() throws Exception {
        when(engineService.removeEngineById(anyLong())).thenReturn(Boolean.TRUE);
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(delete(url))
                .andExpect(status().isOk())
                .andDo(print());
    }
}