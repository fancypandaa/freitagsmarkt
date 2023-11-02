package auto.cc.info.converters;

import auto.cc.info.commands.FuelCommand;
import auto.cc.info.domain.Fuel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class FuelCommandToFuel implements Converter<FuelCommand, Fuel> {
    @Override
    @Nullable
    @Synchronized
    public Fuel convert(FuelCommand source) {
        if(source == null) return null;
        final Fuel fuel = new Fuel();
        fuel.setId(source.getId());
        fuel.setFuelType(source.getFuelType());
        fuel.setTankVolume(source.getTankVolume());
        fuel.setFuelCapPosition(source.getFuelCapPosition());
        fuel.setFuelConsumptionNEDC(source.getFuelConsumptionNEDC());
        fuel.setCo2Combined(source.getCo2Combined());
        fuel.setTopSpeed(source.getTopSpeed());
        fuel.setAcceleration(source.getAcceleration());
        return fuel;
    }
}
