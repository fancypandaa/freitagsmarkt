package auto.freitagsmarkt.service.components;


import auto.freitagsmarkt.dto.components.SafetyAndSecurityDTO;

public interface SafetyAndSecurityService {
    SafetyAndSecurityDTO addNewSafetyAndSecurity(SafetyAndSecurityDTO safetyAndSecurityDTO);
    SafetyAndSecurityDTO findBySafetyAndSecurityId(Long id);
}
