package auto.cc.info.converters;

import auto.cc.info.commands.BrakesCommand;
import auto.cc.info.domain.Brakes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BrakesToBrakesCommand implements Converter<Brakes,BrakesCommand> {
    @Synchronized
    @Nullable
    @Override
    public BrakesCommand convert(Brakes source) {
        if (source == null) {
            return null;
        }
        final BrakesCommand brakes= new BrakesCommand();
        brakes.setId(source.getId());
        brakes.setFrontBrakes(source.getFrontBrakes());
        brakes.setParkingBrake(source.getParkingBrake());
        brakes.setRearBrakes(source.getRearBrakes());
        brakes.setManual(source.getManual());
        brakes.setCooling(source.getCooling());
        return brakes;
    }
}
