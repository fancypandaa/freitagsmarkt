package auto.cc.info.converters;

import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.CarBrand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CarBrandToCarBrandCommandTest {

    public static final Long ID_VALUE = 1l;
    public static final String NAME = "Volvo";
    public static final String COUNTRY_OF_ORIGIN = "Sweden";
    public static final Integer PRODUCTION_YEAR = 1990;
    public static final String SERIES = "A";
    public static final String LOGO = "http://url.com";
    public static final Long CARID_1 = 1L;
    public static final Long CARID_2 = 2L;
    CarBrandToCarBrandCommand converter;
    @Mock
    CarToCarCommand carToCarCommand;
    @BeforeEach
    void setUp() {
        converter = new CarBrandToCarBrandCommand(carToCarCommand);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CarBrand()));
    }
    @Test
    void convert() {
        CarBrand carBrand = new CarBrand();
        carBrand.setId(ID_VALUE);
        carBrand.setName(NAME);
        carBrand.setLogoUrl(LOGO);
        carBrand.setProductionYears(PRODUCTION_YEAR);
        carBrand.setCountryOfOrigin(COUNTRY_OF_ORIGIN);
        CarBrandCommand carBrandCommand = converter.convert(carBrand);
        assertNotNull(carBrandCommand);
        assertEquals(ID_VALUE, carBrandCommand.getId());
        assertEquals(NAME, carBrandCommand.getName());
        assertEquals(LOGO, carBrandCommand.getLogoUrl());
        assertEquals(PRODUCTION_YEAR, carBrandCommand.getProductionYears());
        assertEquals(COUNTRY_OF_ORIGIN, carBrandCommand.getCountryOfOrigin());
    }
}