package auto.freitagsmarkt.controller;

import auto.freitagsmarkt.domain.enums.SellerType;
import auto.freitagsmarkt.dto.SellerDTO;
import auto.freitagsmarkt.service.SellerService;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SellerControllerTest {

    private static final String MAIN_URI ="/api/seller";
    private MockMvc mockMvc;
    private SellerService sellerService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        sellerService = Mockito.mock(SellerService.class);
        objectMapper = new ObjectMapper();
        SellerController sellerController = new SellerController(sellerService);
        mockMvc = MockMvcBuilders.standaloneSetup(sellerController).build();
    }

    @Test
    void listAllSeller() throws Exception {
        List<SellerDTO> sellerDTOList= Arrays.asList(
                SellerDTO.builder().sellerId(1L).type(SellerType.INDIVIDUAL).sellerWebsite("www.test.com")
                        .phone("555-555-555").name("test").build(),
                SellerDTO.builder().sellerId(1L).type(SellerType.COMPANY).sellerWebsite("www.testI.com")
                        .phone("123-123-123").name("testI").build()
                );
        String url = String.format("%s/list-sellers", MAIN_URI);

        when(sellerService.listSellers(0,10)).thenReturn(sellerDTOList);
        mockMvc.perform(get(url)
                        .param("page","0")
                        .param("size","10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",is(2)))
                .andExpect(jsonPath("$[0].type",is(SellerType.INDIVIDUAL.toString())));

    }

    @Test
    void findBySellerId() throws Exception {
        when(sellerService.findSellerById(anyLong())).thenReturn(
                SellerDTO.builder().sellerId(1L).type(SellerType.INDIVIDUAL).sellerWebsite("www.test.com")
                        .phone("555-555-555").name("test").build());
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sellerId").value(is(1)))
                .andExpect(jsonPath("$.type").value(SellerType.INDIVIDUAL.toString()));
    }

    @Test
    void addNewSeller() throws Exception{
        SellerDTO sellerDTO=SellerDTO.
                builder()
                .sellerId(1L)
                .type(SellerType.INDIVIDUAL)
                .name("sellerOne")
                .phone("222-555-333")
                .sellerWebsite("N/A")
                .build();

        when(sellerService.createNewSellerProfile(any(SellerDTO.class))).thenReturn(sellerDTO);
        String url = String.format("%s", MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(sellerDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.sellerId").value(is(1)))
                .andExpect(jsonPath("$.type").value(SellerType.INDIVIDUAL.toString()))
                .andExpect(jsonPath("$.name").value(is("sellerOne")));
    }

    @Test
    void updateSeller() throws Exception{
        SellerDTO sellerDTO=SellerDTO.
                builder()
                .sellerId(1L)
                .type(SellerType.INDIVIDUAL)
                .name("sellerOne")
                .phone("222-555-333")
                .sellerWebsite("N/A")
                .build();
        SellerDTO updatedSellerDTO=SellerDTO.
                builder()
                .sellerId(1L)
                .type(SellerType.INDIVIDUAL)
                .name("sellerOne")
                .phone("222-111-333")
                .sellerWebsite("www.one.com")
                .build();

        when(sellerService.updateSeller(Mockito.eq(1L),any(SellerDTO.class))).thenReturn(updatedSellerDTO);
        String url = String.format("%s/%s", MAIN_URI,1L);
        mockMvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(sellerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sellerId").value(is(1)))
                .andExpect(jsonPath("$.sellerWebsite").value(is("www.one.com")))
                .andExpect(jsonPath("$.phone").value(is("222-111-333")));
    }

    @Test
    void deleteSellerById() throws Exception {
        when(sellerService.removeSellerById(anyLong())).thenReturn(Boolean.TRUE);
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(delete(url))
                .andExpect(status().isOk())
                .andDo(print());
    }
}