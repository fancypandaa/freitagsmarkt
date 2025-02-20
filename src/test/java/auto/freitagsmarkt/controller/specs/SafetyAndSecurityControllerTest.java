package auto.freitagsmarkt.controller.specs;

import auto.freitagsmarkt.dto.specs.SafetyAndSecurityDTO;
import auto.freitagsmarkt.service.specs.SafetyAndSecurityService;
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

class SafetyAndSecurityControllerTest {
    private static final String MAIN_URI ="/api/safetyAndSecurity";
    private MockMvc mockMvc;
    private SafetyAndSecurityService safetyAndSecurityService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        safetyAndSecurityService = Mockito.mock(SafetyAndSecurityService.class);
        objectMapper = new ObjectMapper();
        SafetyAndSecurityController safetyAndSecurityController = new SafetyAndSecurityController(safetyAndSecurityService);
        mockMvc = MockMvcBuilders.standaloneSetup(safetyAndSecurityController).build();
    }
    @Test
    void addNewSafetyAndSecurity() throws Exception {
        SafetyAndSecurityDTO safetyAndSecurityDTO = SafetyAndSecurityDTO.builder().safetyId(1L)
                .seatBelt("{\"SeatBeltColour\":\"Black\"}")
                .assistSystems("{\"HillStartAssist_HSA\":\"Yes\"}")
                .brakeSystem("{\"AntiLockBrakingSystem_ABS\":\"Four-channel\",\"ElectronicBrakeAssist_BA/EBA\":\"Yes\"}").build();
        when(safetyAndSecurityService.addNewSafetyAndSecurity(any(SafetyAndSecurityDTO.class))).thenReturn(safetyAndSecurityDTO);
        String url = String.format("%s", MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(safetyAndSecurityDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.seatBelt").value(is("{\"SeatBeltColour\":\"Black\"}")))
                .andExpect(jsonPath("$.assistSystems").value(is("{\"HillStartAssist_HSA\":\"Yes\"}")))
                .andExpect(jsonPath("$.brakeSystem").value(is("{\"AntiLockBrakingSystem_ABS\":\"Four-channel\",\"ElectronicBrakeAssist_BA/EBA\":\"Yes\"}")));
    }

    @Test
    void findSafetyAndSecurityById() throws Exception {
        when(safetyAndSecurityService.findBySafetyAndSecurityId(anyLong())).thenReturn(
                SafetyAndSecurityDTO.builder().safetyId(1L)
                        .seatBelt("{\"SeatBeltColour\":\"Black\"}")
                        .assistSystems("{\"HillStartAssist_HSA\":\"Yes\"}")
                        .brakeSystem("{\"AntiLockBrakingSystem_ABS\":\"Four-channel\",\"ElectronicBrakeAssist_BA/EBA\":\"Yes\"}").build()
        );
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.assistSystems").value(is("{\"HillStartAssist_HSA\":\"Yes\"}")))
                .andExpect(jsonPath("$.brakeSystem").value(is("{\"AntiLockBrakingSystem_ABS\":\"Four-channel\",\"ElectronicBrakeAssist_BA/EBA\":\"Yes\"}")));
    }
}