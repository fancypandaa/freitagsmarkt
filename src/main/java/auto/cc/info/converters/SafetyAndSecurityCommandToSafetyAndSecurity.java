package auto.cc.info.converters;

import auto.cc.info.commands.SafetyAndSecurityCommand;
import auto.cc.info.domain.SafetyAndSecurity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SafetyAndSecurityCommandToSafetyAndSecurity implements Converter<SafetyAndSecurityCommand, SafetyAndSecurity> {
    @Override
    @Nullable
    @Transactional
    public SafetyAndSecurity convert(SafetyAndSecurityCommand source) {
       if(source==null) return null;

        final SafetyAndSecurity safetyAndSecurity = new SafetyAndSecurity();
        safetyAndSecurity.setId(source.getId());
        safetyAndSecurity.setSeatBelt(source.getSeatBelt());
        safetyAndSecurity.setAssistSystems(source.getAssistSystems());
        safetyAndSecurity.setBrakeSystem(source.getBrakeSystem());
        safetyAndSecurity.setSensors(source.getSensors());
        safetyAndSecurity.setSafetyTesting(source.getSafetyTesting());
        safetyAndSecurity.setAirbags(source.getAirbags());
        safetyAndSecurity.setChildProtection(source.getChildProtection());
        safetyAndSecurity.setOthersFeatures(source.getOthersFeatures());
        return safetyAndSecurity;
    }
}
