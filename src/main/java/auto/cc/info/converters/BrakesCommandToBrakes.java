package auto.cc.info.converters;

import auto.cc.info.commands.BrakesCommand;
import auto.cc.info.domain.Brakes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BrakesCommandToBrakes implements Converter<BrakesCommand, Brakes> {
    @Synchronized
    @Nullable
    @Override
    public Brakes convert(BrakesCommand source) {
        if (source == null) {
            return null;
        }
        final Brakes brakes= new Brakes();
        brakes.setId(source.getId());
        brakes.setFrontBrakes(source.getFrontBrakes());
        brakes.setParkingBrake(source.getParkingBrake());
        brakes.setRearBrakes(source.getRearBrakes());
        brakes.setManual(source.getManual());
        brakes.setCooling(source.getCooling());
        return brakes;
    }
}
