package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.specs.SafetyAndSecurity;
import auto.freitagsmarkt.dto.specs.SafetyAndSecurityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SafetyAndSecurityMapper {
    SafetyAndSecurityMapper INSTANCE = Mappers.getMapper(SafetyAndSecurityMapper.class);
    SafetyAndSecurityDTO toSafetyAndSecurityDTO(SafetyAndSecurity safetyAndSecurity);
    SafetyAndSecurity toSafetyAndSecurity(SafetyAndSecurityDTO safetyAndSecurityDTO);
}
