package auto.cc.info.converters;

import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.commands.CarCommand;
import auto.cc.info.domain.CarBrand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CarBrandCommandToCarBrandTest {
    public static final Long ID_VALUE = 1l;
    public static final String NAME = "Volvo";
    public static final String COUNTRY_OF_ORIGIN = "Sweden";
    public static final Integer PRODUCTION_YEAR = 1990;
    public static final String SERIES = "A";
    public static final String LOGO = "http://url.com";
    public static final Long CARID_1 = 1L;
    public static final Long CARID_2 = 2L;
    CarBrandCommandToCarBrand converter;
    @Mock
    CarCommandToCar carCommandToCar;
    @BeforeEach
    void setUp() {
        converter = new CarBrandCommandToCarBrand(carCommandToCar);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CarBrandCommand()));
    }
    @Test
    void convert() {
        CarBrandCommand carBrandCommand = new CarBrandCommand();
        carBrandCommand.setId(ID_VALUE);
        carBrandCommand.setName(NAME);
        carBrandCommand.setLogoUrl(LOGO);
        carBrandCommand.setProductionYears(PRODUCTION_YEAR);
        carBrandCommand.setCountryOfOrigin(COUNTRY_OF_ORIGIN);
        CarBrand carBrand = converter.convert(carBrandCommand);
        assertNotNull(carBrand);
        assertEquals(ID_VALUE, carBrand.getId());
        assertEquals(NAME, carBrand.getName());
        assertEquals(LOGO, carBrand.getLogoUrl());
        assertEquals(PRODUCTION_YEAR, carBrand.getProductionYears());
        assertEquals(COUNTRY_OF_ORIGIN, carBrand.getCountryOfOrigin());
    }
}