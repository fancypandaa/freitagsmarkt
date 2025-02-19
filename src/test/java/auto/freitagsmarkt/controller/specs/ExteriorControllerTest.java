package auto.freitagsmarkt.controller.specs;

import auto.freitagsmarkt.domain.enums.ChassisType;
import auto.freitagsmarkt.dto.specs.ExteriorDTO;
import auto.freitagsmarkt.service.specs.ExteriorService;
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

class ExteriorControllerTest {
    private static final String MAIN_URI ="/api/exterior";
    private MockMvc mockMvc;
    private ExteriorService exteriorService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        exteriorService = Mockito.mock(ExteriorService.class);
        objectMapper = new ObjectMapper();
        ExteriorController exteriorController = new ExteriorController(exteriorService);
        mockMvc = MockMvcBuilders.standaloneSetup(exteriorController).build();
    }
    @Test
    void addNewExterior() throws Exception {
        ExteriorDTO exteriorDTO = ExteriorDTO.builder().exId(1L).chassis(ChassisType.MPV).numberOfDoors(4).frontDoors("Conventional")
                .backDoors("Conventional").platform("CMA").chassisOptions("SUV").build();
        when(exteriorService.createExterior(any(ExteriorDTO.class))).thenReturn(exteriorDTO);
        String url = String.format("%s", MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(exteriorDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.exId").value(is(1)))
                .andExpect(jsonPath("$.chassisOptions").value(is("SUV")))
                .andExpect(jsonPath("$.backDoors").value(is("Conventional")));

    }

    @Test
    void findExteriorById() throws Exception {

        when(exteriorService.findByExteriorId(anyLong())).thenReturn(
                ExteriorDTO.builder().exId(1L).chassis(ChassisType.MPV).numberOfDoors(4).frontDoors("Conventional")
                        .backDoors("Conventional").platform("CMA").chassisOptions("SUV").build()
        );
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.exId").value(is(1)))
                .andExpect(jsonPath("$.backDoors").value(is("Conventional")));
    }
}