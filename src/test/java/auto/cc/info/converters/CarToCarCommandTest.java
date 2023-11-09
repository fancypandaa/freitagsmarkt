package auto.cc.info.converters;

import auto.cc.info.commands.*;
import auto.cc.info.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarToCarCommandTest {
    private static final Long ID_VALUE=1L;
    private static final String MODEL="GOLF";
    private static final String CITY="Berlin";
    private static final Integer DAYS=20;
    private static final Long PRICE=2000L;
    private static final Long MILEAGE=200L;
    private static final String GENERATION="type 2";
    private static final String SALESTATUS="Sold";
    private CarToCarCommand converter;

    @BeforeEach
    void setUp() {
        converter = new CarToCarCommand(
                new EngineToEngineCommand(new BrakesToBrakesCommand(),new SuspensionsToSuspensionsCommand(),
                        new FuelToFuelCommand(),new TransmissionToTransmissionCommand()),
                new DimAndWeightToDimAndWeightCommand(),
                new ExteriorToExteriorCommand(new ExEquipmentToExEquipmentCommand()),
                new InteriorToInteriorCommand(new InEquipmentsToInEquipmentsCommand()),
                new FeaturesToFeaturesCommand(),
                new SafetyAndSecurityToSafetyAndSecurityCommand()
        );
    }
    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    void convert() {
        Car car=new Car();
        car.setId(ID_VALUE);
        car.setModel(MODEL);
        car.setCity(CITY);
        car.setDays(DAYS);
        car.setPrice(PRICE);
        car.setMileage(MILEAGE);
        car.setSaleStatus(SALESTATUS);
        car.setGeneration(GENERATION);
        CarBrand carBrand=new CarBrand();
        carBrand.setId(ID_VALUE);
        car.setCarBrand(carBrand);
        Seller seller=new Seller();
        seller.setId(ID_VALUE);
        car.setSeller(seller);
        Engine engine = new Engine();
        engine.setId(ID_VALUE);
        DimensionsAndWeight dimensionsAndWeight=new DimensionsAndWeight();
        dimensionsAndWeight.setId(ID_VALUE);
        Exterior exterior= new Exterior();
        exterior.setId(ID_VALUE);
        Interior interior=new Interior();
        interior.setId(ID_VALUE);
        Features features=new Features();
        features.setId(ID_VALUE);
        SafetyAndSecurity safetyAndSecurity=new SafetyAndSecurity();
        safetyAndSecurity.setId(ID_VALUE);
        car.setEngine(engine);
        car.setDimensionsAndWeight(dimensionsAndWeight);
        car.setExterior(exterior);
        car.setInterior(interior);
        car.setFeatures(features);
        car.setSafetyAndSecurity(safetyAndSecurity);
        CarCommand carCommand= converter.convert(car);
        assertNotNull(carCommand);
        assertEquals(ID_VALUE, carCommand.getId());
        assertEquals(MODEL, carCommand.getModel());
        assertEquals(CITY, carCommand.getCity());
        assertEquals(DAYS, carCommand.getDays());
        assertEquals(PRICE, carCommand.getPrice());
        assertEquals(MILEAGE, carCommand.getMileage());
        assertEquals(SALESTATUS, carCommand.getSaleStatus());
        assertEquals(GENERATION, carCommand.getGeneration());
        assertEquals(ID_VALUE, carCommand.getEngine().getId());
        assertEquals(ID_VALUE, carCommand.getDimensionsAndWeight().getId());
        assertEquals(ID_VALUE, carCommand.getSafetyAndSecurity().getId());

    }

}