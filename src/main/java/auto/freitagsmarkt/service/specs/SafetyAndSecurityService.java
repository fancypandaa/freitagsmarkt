package auto.freitagsmarkt.service.specs;


import auto.freitagsmarkt.dto.specs.SafetyAndSecurityDTO;

public interface SafetyAndSecurityService {
    SafetyAndSecurityDTO addNewSafetyAndSecurity(SafetyAndSecurityDTO safetyAndSecurityDTO);
    SafetyAndSecurityDTO findBySafetyAndSecurityId(Long id);
}
