package auto.cc.info.service;

import auto.cc.info.dto.otherComponents.SafetyAndSecurityCommand;

public interface SafetyAndSecurityService {
    SafetyAndSecurityCommand addNewSafetyAndSecurity(SafetyAndSecurityCommand safetyAndSecurityCommand);
    SafetyAndSecurityCommand findBySSId(Long id);
}
