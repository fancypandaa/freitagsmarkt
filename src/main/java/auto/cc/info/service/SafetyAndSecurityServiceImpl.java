package auto.cc.info.service;

import auto.cc.info.commands.SafetyAndSecurityCommand;
import auto.cc.info.converters.SafetyAndSecurityCommandToSafetyAndSecurity;
import auto.cc.info.converters.SafetyAndSecurityToSafetyAndSecurityCommand;
import auto.cc.info.domain.SafetyAndSecurity;
import auto.cc.info.repository.SafetyAndSecurityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class SafetyAndSecurityServiceImpl implements SafetyAndSecurityService{
    private final SafetyAndSecurityRepository safetyAndSecurityRepository;
    private final SafetyAndSecurityToSafetyAndSecurityCommand securityToSafetyAndSecurityCommand;
    private final SafetyAndSecurityCommandToSafetyAndSecurity safetyAndSecurityCommandToSafetyAndSecurity;

    public SafetyAndSecurityServiceImpl(SafetyAndSecurityRepository safetyAndSecurityRepository, SafetyAndSecurityToSafetyAndSecurityCommand securityToSafetyAndSecurityCommand, SafetyAndSecurityCommandToSafetyAndSecurity safetyAndSecurityCommandToSafetyAndSecurity) {
        this.safetyAndSecurityRepository = safetyAndSecurityRepository;
        this.securityToSafetyAndSecurityCommand = securityToSafetyAndSecurityCommand;
        this.safetyAndSecurityCommandToSafetyAndSecurity = safetyAndSecurityCommandToSafetyAndSecurity;
    }


    @Override
    @Transactional

    public SafetyAndSecurityCommand addNewSafetyAndSecurity(SafetyAndSecurityCommand safetyAndSecurityCommand) {
        SafetyAndSecurity safetyAndSecurity= safetyAndSecurityCommandToSafetyAndSecurity.convert(safetyAndSecurityCommand);
        safetyAndSecurityRepository.save(safetyAndSecurity);
        return safetyAndSecurityCommand;
    }
}
