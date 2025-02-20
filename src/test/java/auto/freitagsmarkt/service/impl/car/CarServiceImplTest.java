package auto.freitagsmarkt.service.impl.car;


import auto.freitagsmarkt.domain.car.Car;
import auto.freitagsmarkt.dto.car.CarDTO;
import auto.freitagsmarkt.mapper.car.CarMapper;
import auto.freitagsmarkt.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {
    @Mock
    private CarRepository carRepository;
    @Mock
    private CarMapper carMapper;
    @InjectMocks
    private CarServiceImpl carService;
    private Car car;
    private CarDTO carDTO;
    @BeforeEach
    void setUp() {
        car = new Car();
        carDTO =CarDTO.builder().build();
    }

    @Test
    void listAllCar_whenNoCarExist() {
        when(carRepository.findAll(any(PageRequest.class))).thenReturn(Page.empty());
        List<CarDTO> carDTOList = carService.listCars(0,10);
        assertTrue(carDTOList.isEmpty());
        verify(carRepository,times(1)).findAll(any(PageRequest.class));
    }
    @Test
    void listAllCar_whenCarExist() {
        when(carRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(car)));
        when(carMapper.toCarListDTO(anyList())).thenReturn(List.of(carDTO));
        List<CarDTO> carDTOs = carService.listCars(0,5);
        assertFalse(carDTOs.isEmpty());
        verify(carRepository,times(1)).findAll(any(PageRequest.class));
        verify(carMapper,times(1)).toCarListDTO(anyList());
    }
    @Test
    void listAllCar_whenCarExist_wrongPage() {
        when(carRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(car)));
        List<CarDTO> carDTOs = carService.listCars(2,5);
        assertTrue(carDTOs.isEmpty());
        verify(carRepository,times(1)).findAll(any(PageRequest.class));
    }
    @Test
    void createNewCar_success() {
        when(carMapper.toCar(any())).thenReturn(car);
        when(carRepository.save(any())).thenReturn(car);
        when(carMapper.toCarDTO(any())).thenReturn(carDTO);
        CarDTO savedAd = carService.addNewCar(carDTO);
        assertNotNull(savedAd);
        verify(carRepository,times(1)).save(any());
        verify(carMapper,times(1)).toCar(carDTO);
    }
    @Test
    void createNewCar_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> carService.addNewCar(null));
        assertEquals("Car not created",exception.getMessage());
    }
    @Test
    void findCarById_success() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.of(car));
        when(carMapper.toCarDTO(any())).thenReturn(carDTO);
        CarDTO savedCarDTO = carService.findCarById(1L);
        assertNotNull(savedCarDTO);
        verify(carRepository,times(1)).findById(1L);
    }
    @Test
    void findCarById_notFound() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> carService.findCarById(anyLong()));
        assertEquals("Car Not Found",exception.getMessage());
    }
    @Test
    void updateCar_success() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.of(car));
        when(carRepository.save(any())).thenReturn(car);
        when(carMapper.toCarDTO(any())).thenReturn(carDTO);
        CarDTO savedCar = carService.updateCarById(anyLong(),carDTO);
        assertNotNull(savedCar);
        verify(carMapper,times(1)).updateCarFromCarDTO(carDTO,car);
        verify(carRepository,times(1)).save(any());
    }
    @Test
    void updateCar_notFound() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> carService.updateCarById(anyLong(),carDTO));
        assertEquals("Car Not updated",exception.getMessage());
    }
    @Test
    void removeCarById_Success() {
        when(carRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(carRepository).deleteById(anyLong());
        Boolean ans = carService.removeCarById(anyLong());
        assertTrue(ans);
        verify(carRepository,times(1)).deleteById(anyLong());
    }
    @Test
    void removeCarById_notFound() {
        when(carRepository.existsById(anyLong())).thenReturn(false);
        Boolean ans = carService.removeCarById(anyLong());
        assertFalse(ans);
    }
    
}