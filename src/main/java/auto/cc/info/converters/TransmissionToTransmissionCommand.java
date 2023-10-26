package auto.cc.info.converters;

import auto.cc.info.commands.TransmissionCommand;
import auto.cc.info.domain.Transmission;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TransmissionToTransmissionCommand implements Converter<Transmission,TransmissionCommand> {
    @Override
    @Synchronized
    @Nullable
    public TransmissionCommand convert(Transmission source) {
        if (source == null) {
            return null;
        }
        TransmissionCommand transmissionCommand = new TransmissionCommand();
        transmissionCommand.setId(source.getId());
        transmissionCommand.setDriveTrain(source.getDriveTrain());
        transmissionCommand.setTransmission(source.getTransmission());
        return transmissionCommand;
    }
}
