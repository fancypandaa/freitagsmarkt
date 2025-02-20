package auto.freitagsmarkt.controller;

import auto.freitagsmarkt.domain.enums.AdsStatus;
import auto.freitagsmarkt.dto.AdsDTO;
import auto.freitagsmarkt.service.AdsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AdsControllerTest {
    private static final String MAIN_URI ="/api/ads";
    private MockMvc mockMvc;
    private AdsService adsService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        adsService = Mockito.mock(AdsService.class);
        objectMapper = new ObjectMapper();
        AdsController adsController = new AdsController(adsService);
        mockMvc = MockMvcBuilders.standaloneSetup(adsController).build();
    }

    @Test
    void listAds() throws Exception{
        List<AdsDTO> adsDTOList= Arrays.asList(
                AdsDTO.builder().adId(1L).status(AdsStatus.ACTIVE).published(new Date()).daysOfSale(5).build(),
                AdsDTO.builder().adId(2L).status(AdsStatus.PENDING).published(new Date(-2)).daysOfSale(4).build()
                );
        String url = String.format("%s/all-ads", MAIN_URI,1L);

        when(adsService.listAllAds(0,10)).thenReturn(adsDTOList);
        mockMvc.perform(get(url)
                .param("page","0")
                .param("size","10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",is(2)))
                .andExpect(jsonPath("$[0].daysOfSale",is(5)));
    }

    @Test
    void findAdById() throws Exception {
        when(adsService.findAdById(anyLong())).thenReturn(
                AdsDTO.builder().adId(1L).status(AdsStatus.ACTIVE).published(new Date()).daysOfSale(5).build()
        );
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.adId").value(is(1)))
                .andExpect(jsonPath("$.status").value(AdsStatus.ACTIVE.toString()));
    }

    @Test
    void createNewAd() throws Exception {
        AdsDTO adsDTO=AdsDTO.
                builder()
                .adId(1L)
                .status(AdsStatus.PENDING)
                .published(new Date())
                .daysOfSale(10).build();

        when(adsService.createNewAd(any(AdsDTO.class))).thenReturn(adsDTO);
        String url = String.format("%s", MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(adsDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.adId").value(is(1)))
                .andExpect(jsonPath("$.status").value(AdsStatus.PENDING.toString()))
                .andExpect(jsonPath("$.daysOfSale").value(is(10)));
    }

    @Test
    void updateAds() throws Exception {
        AdsDTO adsDTO=AdsDTO.
                builder()
                .adId(1L)
                .status(AdsStatus.ACTIVE)
                .published(new Date())
                .daysOfSale(10).build();
        AdsDTO updatedAdsDTO = AdsDTO.builder().adId(1L).status(AdsStatus.PENDING).published(new Date()).daysOfSale(10).build();

        when(adsService.updateAd(Mockito.eq(1L),any(AdsDTO.class))).thenReturn(updatedAdsDTO);
        String url = String.format("%s/%s", MAIN_URI,1L);
        mockMvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(adsDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.adId").value(is(1)))
                .andExpect(jsonPath("$.status").value(AdsStatus.PENDING.toString()))
                .andExpect(jsonPath("$.daysOfSale").value(is(10)));
    }

    @Test
    void deleteAdsById() throws Exception {
        when(adsService.removeAdById(anyLong())).thenReturn(Boolean.TRUE);
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(delete(url))
                .andExpect(status().isOk())
                .andDo(print());
    }
}