package auto.freitagsmarkt.service.impl.specs;


import auto.freitagsmarkt.dto.specs.SafetyAndSecurityDTO;
import auto.freitagsmarkt.mapper.specs.SafetyAndSecurityMapper;
import auto.freitagsmarkt.repository.specs.SafetyAndSecurityRepository;
import auto.freitagsmarkt.service.specs.SafetyAndSecurityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SafetyAndSecurityServiceImpl implements SafetyAndSecurityService {
    private SafetyAndSecurityMapper safetyAndSecurityMapper;
    private SafetyAndSecurityRepository safetyAndSecurityRepository;

    public SafetyAndSecurityServiceImpl(
            SafetyAndSecurityMapper safetyAndSecurityMapper,
            SafetyAndSecurityRepository safetyAndSecurityRepository) {
        this.safetyAndSecurityMapper = safetyAndSecurityMapper;
        this.safetyAndSecurityRepository = safetyAndSecurityRepository;
    }

    @Override
    public SafetyAndSecurityDTO addNewSafetyAndSecurity(SafetyAndSecurityDTO safetyAndSecurityDTO) {
        return Optional.ofNullable(safetyAndSecurityDTO)
                .map(safetyAndSecurityMapper::toSafetyAndSecurity)
                .map(safetyAndSecurityRepository::save)
                .map(safetyAndSecurityMapper::toSafetyAndSecurityDTO)
                .orElseThrow(()-> new RuntimeException("failed to create SafetyAndSecurity new Item"));
    }

    @Override
    public SafetyAndSecurityDTO findBySafetyAndSecurityId(Long id) {
        return safetyAndSecurityRepository.findById(id)
                .map(safetyAndSecurityMapper::toSafetyAndSecurityDTO)
                .orElseThrow(()-> new RuntimeException("safety And security item not found"));
    }
}
