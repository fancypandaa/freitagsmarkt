package auto.cc.info.converters;

import auto.cc.info.commands.*;
import auto.cc.info.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCommandToCarTest {
    private static final Long ID_VALUE=1L;
    private static final String MODEL="GOLF";
    private static final String CITY="Berlin";
    private static final Integer DAYS=20;
    private static final Long PRICE=2000L;
    private static final Long MILEAGE=200L;
    private static final String GENERATION="type 2";
    private static final String SALESTATUS="Sold";
    private CarCommandToCar converter;

    @BeforeEach
    void setUp() {
        converter = new CarCommandToCar(
                new EngineCommandToEngine(new BrakesCommandToBrakes(),new SuspensionsCommandToSuspensions(),
                        new FuelCommandToFuel(),new TransmissionCommandToTransmission()),
                new DimAndWeightCommandToDimAndWeight(),
                new ExteriorCommandToExterior(new ExEquipmentCommandToExEquipment()),
                new InteriorCommandToInterior(new InEquipmentsCommandToInEquipments()),
                new FeaturesCommandToFeatures(),
                new SafetyAndSecurityCommandToSafetyAndSecurity()
                );
    }
    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CarCommand()));
    }
    @Test
    void convert() {
        CarCommand carCommand=new CarCommand();
        carCommand.setId(ID_VALUE);
        carCommand.setModel(MODEL);
        carCommand.setCity(CITY);
        carCommand.setDays(DAYS);
        carCommand.setPrice(PRICE);
        carCommand.setMileage(MILEAGE);
        carCommand.setSaleStatus(SALESTATUS);
        carCommand.setGeneration(GENERATION);
        EngineCommand engineCommand = new EngineCommand();
        engineCommand.setId(ID_VALUE);
        DimensionsAndWeightCommand dimensionsAndWeightCommand=new DimensionsAndWeightCommand();
        dimensionsAndWeightCommand.setId(ID_VALUE);
        ExteriorCommand exteriorCommand= new ExteriorCommand();
        exteriorCommand.setId(ID_VALUE);
        InteriorCommand interiorCommand=new InteriorCommand();
        interiorCommand.setId(ID_VALUE);
        FeaturesCommand featuresCommand=new FeaturesCommand();
        featuresCommand.setId(ID_VALUE);
        SafetyAndSecurityCommand safetyAndSecurityCommand=new SafetyAndSecurityCommand();
        safetyAndSecurityCommand.setId(ID_VALUE);
        carCommand.setEngine(engineCommand);
        carCommand.setDimensionsAndWeight(dimensionsAndWeightCommand);
        carCommand.setExterior(exteriorCommand);
        carCommand.setInterior(interiorCommand);
        carCommand.setFeatures(featuresCommand);
        carCommand.setSafetyAndSecurity(safetyAndSecurityCommand);
        Car car= converter.convert(carCommand);
        assertNotNull(car);
        assertEquals(ID_VALUE, car.getId());
        assertEquals(MODEL, car.getModel());
        assertEquals(CITY, car.getCity());
        assertEquals(DAYS, car.getDays());
        assertEquals(PRICE, car.getPrice());
        assertEquals(MILEAGE, car.getMileage());
        assertEquals(SALESTATUS, car.getSaleStatus());
        assertEquals(GENERATION, car.getGeneration());
        assertEquals(ID_VALUE, car.getEngine().getId());
        assertEquals(ID_VALUE, car.getDimensionsAndWeight().getId());
        assertEquals(ID_VALUE, car.getSafetyAndSecurity().getId());

    }
}