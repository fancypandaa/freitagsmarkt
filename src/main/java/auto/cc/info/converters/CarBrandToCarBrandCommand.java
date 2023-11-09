package auto.cc.info.converters;

import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.domain.CarBrand;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CarBrandToCarBrandCommand implements Converter<CarBrand, CarBrandCommand> {
    private final CarToCarCommand carCommand;

    public CarBrandToCarBrandCommand(CarToCarCommand carCommand) {
        this.carCommand = carCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public CarBrandCommand convert(CarBrand source) {
        if (source == null) {
            return null;
        }
        final CarBrandCommand carBrandCommand= new CarBrandCommand();
        carBrandCommand.setId(source.getId());
        carBrandCommand.setName(source.getName());
        carBrandCommand.setSeries(source.getSeries());
        carBrandCommand.setLogoUrl(source.getLogoUrl());
        carBrandCommand.setProductionYears(source.getProductionYears());
        carBrandCommand.setCountryOfOrigin(source.getCountryOfOrigin());
        if(source.getCars() != null && source.getCars().size()>0){
            source.getCars().forEach(car ->{
                carBrandCommand.getCars().add(carCommand.convert(car));
            });
        }
        return carBrandCommand;
    }
}
