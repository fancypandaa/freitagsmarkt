package auto.cc.info.service;

import auto.cc.info.commands.SafetyAndSecurityCommand;

public interface SafetyAndSecurityService {
    SafetyAndSecurityCommand addNewSafetyAndSecurity(SafetyAndSecurityCommand safetyAndSecurityCommand);
    SafetyAndSecurityCommand findBySSId(Long id);
}
