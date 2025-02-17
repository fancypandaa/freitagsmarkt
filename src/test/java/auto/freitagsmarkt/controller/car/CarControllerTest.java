package auto.freitagsmarkt.controller.car;

import auto.freitagsmarkt.domain.enums.SaleStatus;
import auto.freitagsmarkt.dto.car.CarDTO;
import auto.freitagsmarkt.service.car.CarService;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CarControllerTest {
    private static final String MAIN_URI ="/api/car";
    private MockMvc mockMvc;
    private CarService carService;
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        carService = Mockito.mock(CarService.class);
        objectMapper = new ObjectMapper();
        CarController carController = new CarController(carService);
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    void listAllCars() throws Exception{
        List<CarDTO> carDTOList= Arrays.asList(
                CarDTO.builder().carId(1L).days(400).city("London").model("2005").price(2000.0).mileage(10000.0)
                        .generation("4").saleStatus(SaleStatus.NEW).build(),
                CarDTO.builder().carId(1L).days(400).city("Paris").model("2006").price(2500.0).mileage(11000.0)
                        .generation("2").saleStatus(SaleStatus.NEW).build()
                );
        String url = String.format("%s/all-cars", MAIN_URI,1L);

        when(carService.listCars(0,10)).thenReturn(carDTOList);
        mockMvc.perform(get(url)
                        .param("page","0")
                        .param("size","10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",is(2)))
                .andExpect(jsonPath("$[0].saleStatus",is(SaleStatus.NEW.toString())));
    }

    @Test
    void findCarById() throws Exception {
        when(carService.findCarById(anyLong())).thenReturn(
                CarDTO.builder().carId(1L).days(400).city("Paris").model("2006").price(2500.0).mileage(11000.0)
                        .generation("2").saleStatus(SaleStatus.USED).build()
        );
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carId").value(is(1)))
                .andExpect(jsonPath("$.saleStatus").value(SaleStatus.USED.toString()));
    }

    @Test
    void addNewCar() throws Exception {
        CarDTO carDTO=CarDTO.builder().carId(1L).days(500).city("London").model("2006").price(2500.0).mileage(11000.0)
                .generation("2").saleStatus(SaleStatus.USED).build();

        when(carService.addNewCar(any(CarDTO.class))).thenReturn(carDTO);
        String url = String.format("%s", MAIN_URI);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(carDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.carId").value(is(1)))
                .andExpect(jsonPath("$.saleStatus").value(SaleStatus.USED.toString()))
                .andExpect(jsonPath("$.city").value(is("London")));
    }

    @Test
    void updateCar() throws Exception {
        CarDTO carDTO=CarDTO.builder().carId(1L).days(500).city("London").model("2006").price(2500.0).mileage(11000.0)
                .generation("2").saleStatus(SaleStatus.USED).build();
        CarDTO updatedCarDTO = CarDTO.builder().carId(1L).days(700).city("London").model("2006").price(2500.0).mileage(12000.0)
                .generation("2").saleStatus(SaleStatus.USED).build();

        when(carService.updateCarById(Mockito.eq(1L),any(CarDTO.class))).thenReturn(updatedCarDTO);
        String url = String.format("%s/%s", MAIN_URI,1L);
        mockMvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(carDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carId").value(is(1)))
                .andExpect(jsonPath("$.days").value(is(700)))
                .andExpect(jsonPath("$.mileage").value(is(12000.0)));
    }

    @Test
    void deleteCarById() throws Exception {
        when(carService.removeCarById(anyLong())).thenReturn(Boolean.TRUE);
        String url = String.format("%s/%s", MAIN_URI, anyLong());
        mockMvc.perform(delete(url))
                .andExpect(status().isOk())
                .andDo(print());
    }


 

 
 
}