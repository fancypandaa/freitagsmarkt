package auto.cc.info.converters;

import auto.cc.info.commands.CarCommand;
import auto.cc.info.domain.Car;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CarToCarCommand implements Converter<Car, CarCommand> {
    private final SpecsToSpecsCommand specsToSpecsCommand;

    public CarToCarCommand(SpecsToSpecsCommand specsToSpecsCommand) {
        this.specsToSpecsCommand = specsToSpecsCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public CarCommand convert(Car source) {
        if (source == null) {
            return null;
        }
        final CarCommand carCommand = new CarCommand();
        carCommand.setId(source.getId());
        carCommand.setDays(source.getDays());
        carCommand.setCity(source.getCity());
        carCommand.setModel(source.getModel());
        carCommand.setGeneration(source.getGeneration());
        carCommand.setMileage(source.getMileage());
        carCommand.setPrice(source.getPrice());
        carCommand.setSpecsCommand(specsToSpecsCommand.convert(source.getSpecs()));
        carCommand.setCarBrandId(source.getCarBrand().getId());
        return carCommand;
    }
}
