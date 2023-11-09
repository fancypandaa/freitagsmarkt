package auto.cc.info.converters;

import auto.cc.info.commands.SuspensionsCommand;
import auto.cc.info.domain.Suspensions;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class SuspensionsCommandToSuspensions implements Converter<SuspensionsCommand, Suspensions> {
    @Override
    @Nullable
    @Synchronized
    public Suspensions convert(SuspensionsCommand source) {
       if(source==null) return null;
        final Suspensions suspensions = new Suspensions();
        suspensions.setId(source.getId());
        suspensions.setSuspensionFront(source.getSuspensionFront());
        suspensions.setSuspensionRear(source.getSuspensionRear());
        suspensions.setAnti_rollBar(source.getAnti_rollBar());
        suspensions.setSpringFront(source.getSpringFront());
        suspensions.setSpringRear(source.getSpringRear());
        return suspensions;
    }
}
