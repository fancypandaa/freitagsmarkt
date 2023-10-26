package auto.cc.info.converters;

import auto.cc.info.commands.TransmissionCommand;
import auto.cc.info.domain.Transmission;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TransmissionCommandToTransmission implements Converter<TransmissionCommand, Transmission> {
    @Override
    @Synchronized
    @Nullable
    public Transmission convert(TransmissionCommand source) {
        if (source == null) {
            return null;
        }
        Transmission transmission= new Transmission();
        transmission.setId(source.getId());
        transmission.setDriveTrain(source.getDriveTrain());
        transmission.setTransmission(source.getTransmission());
        return transmission;
    }
}
