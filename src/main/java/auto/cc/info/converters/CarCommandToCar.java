package auto.cc.info.converters;

import auto.cc.info.commands.CarCommand;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.CarBrand;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CarCommandToCar implements Converter<CarCommand, Car> {
    private final SpecsCommandToSpecs specsCommandToSpecs;

    public CarCommandToCar( SpecsCommandToSpecs specsCommandToSpecs) {
        this.specsCommandToSpecs = specsCommandToSpecs;
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
        if(source.getCarBrandId()!= null){
            CarBrand carBrand = new CarBrand();
            carBrand.setId(source.getCarBrandId());
            car.setCarBrand(carBrand);
            carBrand.setCars(car);
        }
        car.setSpecs(specsCommandToSpecs.convert(source.getSpecsCommand()));
        return car;
    }
}
