package auto.cc.info.converters;

import auto.cc.info.commands.SafetyAndSecurityCommand;
import auto.cc.info.domain.SafetyAndSecurity;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SafetyAndSecurityToSafetyAndSecurityCommand implements Converter<SafetyAndSecurity,SafetyAndSecurityCommand> {
    @Override
    @Nullable
    @Synchronized
    public SafetyAndSecurityCommand convert(SafetyAndSecurity source) {
       if(source==null) return null;

        final SafetyAndSecurityCommand safetyAndSecurityCommand = new SafetyAndSecurityCommand();
        safetyAndSecurityCommand.setId(source.getId());
        safetyAndSecurityCommand.setSeatBelt(source.getSeatBelt());
        safetyAndSecurityCommand.setAssistSystems(source.getAssistSystems());
        safetyAndSecurityCommand.setBrakeSystem(source.getBrakeSystem());
        safetyAndSecurityCommand.setSensors(source.getSensors());
        safetyAndSecurityCommand.setSafetyTesting(source.getSafetyTesting());
        safetyAndSecurityCommand.setAirbags(source.getAirbags());
        safetyAndSecurityCommand.setChildProtection(source.getChildProtection());
        safetyAndSecurityCommand.setOthersFeatures(source.getOthersFeatures());
        return safetyAndSecurityCommand;
    }
}
