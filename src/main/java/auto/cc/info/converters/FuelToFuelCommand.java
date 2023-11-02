package auto.cc.info.converters;

import auto.cc.info.commands.FuelCommand;
import auto.cc.info.domain.Fuel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class FuelToFuelCommand implements Converter<Fuel,FuelCommand> {
    @Override
    @Nullable
    @Synchronized
    public FuelCommand convert(Fuel source) {
        if(source == null) return null;
        final FuelCommand fuelCommand = new FuelCommand();
        fuelCommand.setId(source.getId());
        fuelCommand.setFuelType(source.getFuelType());
        fuelCommand.setTankVolume(source.getTankVolume());
        fuelCommand.setFuelCapPosition(source.getFuelCapPosition());
        fuelCommand.setFuelConsumptionNEDC(source.getFuelConsumptionNEDC());
        fuelCommand.setCo2Combined(source.getCo2Combined());
        fuelCommand.setTopSpeed(source.getTopSpeed());
        fuelCommand.setAcceleration(source.getAcceleration());
        return fuelCommand;
    }
}
