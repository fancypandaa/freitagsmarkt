package auto.freitagsmarkt.controller.car;


import auto.freitagsmarkt.dto.car.CarBrandDTO;
import auto.freitagsmarkt.service.car.CarBrandService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CarBrandControllerTest {

    private static final String MAIN_URI ="/api/carBrand";
    private MockMvc mockMvc;
    private CarBrandService carBrandService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        carBrandService = Mockito.mock(CarBrandService.class);
        objectMapper = new ObjectMapper();
        CarBrandController carBrandController = new CarBrandController(carBrandService);
        mockMvc = MockMvcBuilders.standaloneSetup(carBrandController).build();
    }

    @Test
    void listCarBrand() throws Exception{
        List<CarBrandDTO> carBrandDTOList= Arrays.asList(
                CarBrandDTO.builder().carBrandId(1L).name("Test").logoUrl("Logo").countryOfOrigin("China")
                        .series(5).productionYears(2000).build(),
                CarBrandDTO.builder().carBrandId(2L).name("TestI").logoUrl("Logo").countryOfOrigin("Italy")
                        .series(8).productionYears(2002).build()
                );
        String url = String.format("%s/all-carBrand", MAIN_URI,1L);

        when(carBrandService.listCarBrands(0,10)).thenReturn(carBrandDTOList);
        mockMvc.perform(get(url)
                        .param("page","0")
                        .param("size","10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",is(2)))
                .andExpect(jsonPath("$[0].countryOfOrigin",is("China")));
    }

    @Test
    void findAdById() throws Exception {
        when(carBrandService.findCarBrandById(anyLong())).thenReturn(
                CarBrandDTO.builder().carBrandId(1L).name("Test").logoUrl("Logo").countryOfOrigin("China")
                        .series(5).productionYears(2000).build());
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carBrandId").value(is(1)))
                .andExpect(jsonPath("$.productionYears").value(is(2000)));
    }

    @Test
    void createNewAd() throws Exception {
        CarBrandDTO newCarBrandDTO =CarBrandDTO.builder().carBrandId(1L).name("Test").logoUrl("Logo").countryOfOrigin("China")
                .series(5).productionYears(2000).build();
        when(carBrandService.addNewCarBrand(any(CarBrandDTO.class))).thenReturn(newCarBrandDTO);
        String url = String.format("%s", MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(newCarBrandDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.carBrandId").value(is(1)))
                .andExpect(jsonPath("$.name").value("Test"))
                .andExpect(jsonPath("$.series").value(is(5)));
    }

    @Test
    void updateCarBrand() throws Exception {
        CarBrandDTO newCarBrandDTO =CarBrandDTO.builder().carBrandId(1L).name("Test").logoUrl("Logo").countryOfOrigin("China")
                .series(5).productionYears(2000).build();

        CarBrandDTO updatedCarBrandDTO =CarBrandDTO.builder().carBrandId(1L).name("TestI").logoUrl("Logo.jpg").countryOfOrigin("China")
                .series(5).productionYears(2000).build();

        when(carBrandService.updateCarBrand(Mockito.eq(1L),any(CarBrandDTO.class))).thenReturn(updatedCarBrandDTO);
        String url = String.format("%s/%s", MAIN_URI,1L);
        mockMvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(newCarBrandDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carBrandId").value(is(1)))
                .andExpect(jsonPath("$.name").value(is("TestI")))
                .andExpect(jsonPath("$.logoUrl").value(is("Logo.jpg")));
    }

    @Test
    void deleteCarBrandById() throws Exception {
        when(carBrandService.removeCarBrandById(anyLong())).thenReturn(Boolean.TRUE);
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(delete(url))
                .andExpect(status().isOk())
                .andDo(print());
    }
}