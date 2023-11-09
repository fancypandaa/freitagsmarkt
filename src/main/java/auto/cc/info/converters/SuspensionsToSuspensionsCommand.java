package auto.cc.info.converters;

import auto.cc.info.commands.SuspensionsCommand;
import auto.cc.info.domain.Suspensions;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SuspensionsToSuspensionsCommand implements Converter<Suspensions,SuspensionsCommand> {
    @Override
    @Nullable
    @Synchronized
    public SuspensionsCommand convert(Suspensions source) {
       if(source==null) return null;

        final SuspensionsCommand suspensionsCommand = new SuspensionsCommand();
        suspensionsCommand.setId(source.getId());
        suspensionsCommand.setSuspensionFront(source.getSuspensionFront());
        suspensionsCommand.setSuspensionRear(source.getSuspensionRear());
        suspensionsCommand.setAnti_rollBar(source.getAnti_rollBar());
        suspensionsCommand.setSpringFront(source.getSpringFront());
        suspensionsCommand.setSpringRear(source.getSpringRear());
        return suspensionsCommand;
    }
}
