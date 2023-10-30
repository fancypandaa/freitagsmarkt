package auto.cc.info.converters;

import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.domain.CarBrand;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CarBrandCommandToCarBrand implements Converter<CarBrandCommand, CarBrand> {
    private final CarCommandToCar carCommandToCar;

    public CarBrandCommandToCarBrand(CarCommandToCar carCommandToCar) {
        this.carCommandToCar = carCommandToCar;
    }

    @Nullable
    @Override
    public CarBrand convert(CarBrandCommand source) {
        if (source == null) {
            return null;
        }
        final CarBrand carBrand= new CarBrand();
        carBrand.setId(source.getId());
        carBrand.setName(source.getName());
        carBrand.setSeries(source.getSeries());
        carBrand.setLogoUrl(source.getLogoUrl());
        carBrand.setProductionYears(source.getProductionYears());
        carBrand.setCountryOfOrigin(source.getCountryOfOrigin());
        if(source.getCars() != null && source.getCars().size()>0){
            source.getCars().forEach(car ->{
                carBrand.getCars().add(carCommandToCar.convert(car));
            });
        }
        return carBrand;
    }
}
