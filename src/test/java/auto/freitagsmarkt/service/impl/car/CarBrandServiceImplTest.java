package auto.freitagsmarkt.service.impl.car;

import auto.freitagsmarkt.domain.car.CarBrand;
import auto.freitagsmarkt.dto.car.CarBrandDTO;
import auto.freitagsmarkt.mapper.car.CarBrandMapper;
import auto.freitagsmarkt.repository.CarBrandRepository;
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
class CarBrandServiceImplTest {

    @Mock
    private CarBrandRepository carBrandRepository;
    @Mock
    private CarBrandMapper carBrandMapper;
    @InjectMocks
    private CarBrandServiceImpl carBrandService;
    private CarBrand carBrand;
    private CarBrandDTO carBrandDTO;
    @BeforeEach
    void setUp() {
        carBrand = new CarBrand();
        carBrandDTO =CarBrandDTO.builder().build();
    }

    @Test
    void listAllCarBrand_whenNoCarBrandExist() {
        when(carBrandRepository.findAll(any(PageRequest.class))).thenReturn(Page.empty());
        List<CarBrandDTO> carBrandDTOList = carBrandService.listCarBrands(0,10);
        assertTrue(carBrandDTOList.isEmpty());
        verify(carBrandRepository,times(1)).findAll(any(PageRequest.class));
    }
    @Test
    void listAllCarBrand_whenCarBrandExist() {
        when(carBrandRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(carBrand)));
        when(carBrandMapper.toCarBrandListDTO(anyList())).thenReturn(List.of(carBrandDTO));
        List<CarBrandDTO> carBrandDTOs = carBrandService.listCarBrands(0,5);
        assertFalse(carBrandDTOs.isEmpty());
        verify(carBrandRepository,times(1)).findAll(any(PageRequest.class));
        verify(carBrandMapper,times(1)).toCarBrandListDTO(anyList());
    }
    @Test
    void listAllCarBrand_whenCarBrandExist_wrongPage() {
        when(carBrandRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(carBrand)));
        List<CarBrandDTO> carBrandDTOs = carBrandService.listCarBrands(2,5);
        assertTrue(carBrandDTOs.isEmpty());
        verify(carBrandRepository,times(1)).findAll(any(PageRequest.class));
    }
    @Test
    void createNewCarBrand_success() {
        when(carBrandMapper.toCarBrand(any())).thenReturn(carBrand);
        when(carBrandRepository.save(any())).thenReturn(carBrand);
        when(carBrandMapper.toCarBrandDTO(any())).thenReturn(carBrandDTO);
        CarBrandDTO savedAd = carBrandService.addNewCarBrand(carBrandDTO);
        assertNotNull(savedAd);
        verify(carBrandRepository,times(1)).save(any());
        verify(carBrandMapper,times(1)).toCarBrand(carBrandDTO);
    }
    @Test
    void createNewCarBrand_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> carBrandService.addNewCarBrand(null));
        assertEquals("CarBrand cannot created!!",exception.getMessage());
    }
    @Test
    void findCarBrandById_success() {
        when(carBrandRepository.findById(anyLong())).thenReturn(Optional.of(carBrand));
        when(carBrandMapper.toCarBrandDTO(any())).thenReturn(carBrandDTO);
        CarBrandDTO savedCarBrandDTO = carBrandService.findCarBrandById(1L);
        assertNotNull(savedCarBrandDTO);
        verify(carBrandRepository,times(1)).findById(1L);
    }
    @Test
    void findCarBrandById_notFound() {
        when(carBrandRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> carBrandService.findCarBrandById(anyLong()));
        assertEquals("CarBrand Not Found",exception.getMessage());
    }
    @Test
    void updateCarBrand_success() {
        when(carBrandRepository.findById(anyLong())).thenReturn(Optional.of(carBrand));
        when(carBrandRepository.save(any())).thenReturn(carBrand);
        when(carBrandMapper.toCarBrandDTO(any())).thenReturn(carBrandDTO);
        CarBrandDTO savedAd = carBrandService.updateCarBrand(1L,carBrandDTO);
        assertNotNull(savedAd);
        verify(carBrandMapper,times(1)).updateCarBrandDto(carBrandDTO,carBrand);
        verify(carBrandRepository,times(1)).save(any());
    }
    @Test
    void updateCarBrand_notFound() {
        when(carBrandRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> carBrandService.updateCarBrand(anyLong(),carBrandDTO));
        assertEquals("CarBrand not found",exception.getMessage());
    }
    @Test
    void removeAdById_Success() {
        when(carBrandRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(carBrandRepository).deleteById(anyLong());
        Boolean ans = carBrandService.removeCarBrandById(anyLong());
        assertTrue(ans);
        verify(carBrandRepository,times(1)).deleteById(anyLong());
    }
    @Test
    void removeAdById_notFound() {
        when(carBrandRepository.existsById(anyLong())).thenReturn(false);
        Boolean ans = carBrandService.removeCarBrandById(anyLong());
        assertFalse(ans);
    }}