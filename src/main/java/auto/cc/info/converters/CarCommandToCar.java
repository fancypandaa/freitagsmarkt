package auto.cc.info.converters;

import auto.cc.info.commands.CarCommand;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.CarBrand;
import auto.cc.info.domain.Seller;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CarCommandToCar implements Converter<CarCommand, Car> {
    private final EngineCommandToEngine engineCommandToEngine;
    private final DimAndWeightCommandToDimAndWeight commandToDimensionsAndWeight;
    private final ExteriorCommandToExterior exteriorCommandToExterior;
    private final  InteriorCommandToInterior commandToInterior;
    private final FeaturesCommandToFeatures featuresCommandToFeatures;
    private final SafetyAndSecurityCommandToSafetyAndSecurity commandToSafetyAndSecurity;

    public CarCommandToCar(EngineCommandToEngine engineCommandToEngine, DimAndWeightCommandToDimAndWeight commandToDimensionsAndWeight, ExteriorCommandToExterior exteriorCommandToExterior, InteriorCommandToInterior commandToInterior, FeaturesCommandToFeatures featuresCommandToFeatures, SafetyAndSecurityCommandToSafetyAndSecurity commandToSafetyAndSecurity) {
        this.engineCommandToEngine = engineCommandToEngine;
        this.commandToDimensionsAndWeight = commandToDimensionsAndWeight;
        this.exteriorCommandToExterior = exteriorCommandToExterior;
        this.commandToInterior = commandToInterior;
        this.featuresCommandToFeatures = featuresCommandToFeatures;
        this.commandToSafetyAndSecurity = commandToSafetyAndSecurity;
    }

    @Synchronized
    @Nullable
    @Override
    public Car convert(CarCommand source) {
        if (source == null) {
            return null;
        }
        final Car car = new Car();
        car.setId(source.getId());
        car.setDays(source.getDays());
        car.setCity(source.getCity());
        car.setModel(source.getModel());
        car.setGeneration(source.getGeneration());
        car.setMileage(source.getMileage());
        car.setPrice(source.getPrice());
        car.setSaleStatus(source.getSaleStatus());
        if(source.getCarBrandId()!= null){
            CarBrand carBrand = new CarBrand();
            carBrand.setId(source.getCarBrandId());
            car.setCarBrand(carBrand);
            carBrand.setCars(car);
        }
        if(source.getSellerId()!= null){
            Seller seller = new Seller();
            seller.setId(source.getSellerId());
            car.setSeller(seller);
            seller.addCars(car);
        }
        car.setEngine(engineCommandToEngine.convert(source.getEngine()));
        car.setDimensionsAndWeight(commandToDimensionsAndWeight.convert(source.getDimensionsAndWeight()));
        car.setExterior(exteriorCommandToExterior.convert(source.getExterior()));
        car.setInterior(commandToInterior.convert(source.getInterior()));
        car.setFeatures(featuresCommandToFeatures.convert(source.getFeatures()));
        car.setSafetyAndSecurity(commandToSafetyAndSecurity.convert(source.getSafetyAndSecurity()));
        return car;
    }
}
