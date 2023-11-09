package auto.cc.info.service;

import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.converters.CarBrandCommandToCarBrand;
import auto.cc.info.converters.CarBrandToCarBrandCommand;
import auto.cc.info.domain.CarBrand;
import auto.cc.info.repository.CarBrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarBrandServiceImplTest {
    @Mock
    private CarBrandRepository carBrandRepository;
    @Mock
    private CarBrandToCarBrandCommand carBrandToCarBrandCommand;
    @Mock
    private CarBrandCommandToCarBrand carBrandCommandToCarBrand;
    CarBrandService carBrandService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        carBrandService = new CarBrandServiceImpl(carBrandRepository,carBrandToCarBrandCommand,carBrandCommandToCarBrand);
    }

    @Test
    void listCarBrands() {
        CarBrand carBrand = new CarBrand();
        carBrand.setId(1L);
        CarBrand carBrand1 = new CarBrand();
        carBrand1.setId(2L);
        List<CarBrand> carBrandList = new ArrayList<>();
        carBrandList.add(carBrand);
        carBrandList.add(carBrand1);
        when(carBrandRepository.findAll()).thenReturn(carBrandList);
        verify(carBrandRepository, never()).findAll();
    }

    @Test
    void addNewCarBrand() {
        CarBrand carBrand = new CarBrand();
        carBrand.setId(1L);
        Optional<CarBrand> carBrandOptional = Optional.of(carBrand);
        when(carBrandRepository.findById(anyLong())).thenReturn(carBrandOptional);
        CarBrandCommand carBrandCommand = new CarBrandCommand();
        carBrandCommand.setId(1L);
        when(carBrandToCarBrandCommand.convert(carBrand)).thenReturn(carBrandCommand);
        CarBrandCommand carBrandById = carBrandService.findCarBrandById(anyLong());
        assertNotNull("Null CarBrand returned", String.valueOf(carBrandById.getId()));
        verify(carBrandRepository, times(1)).findById(anyLong());
        verify(carBrandRepository, never()).findAll();
    }
    @Test
    void removeCarBrandById() {
        Long idToDelete = Long.valueOf(2L);
        carBrandService.removeCarBrandById(idToDelete);
        verify(carBrandRepository, times(1)).deleteById(anyLong());

    }
}