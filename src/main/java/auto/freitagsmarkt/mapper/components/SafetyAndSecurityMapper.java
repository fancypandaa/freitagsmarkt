package auto.freitagsmarkt.mapper.components;

import auto.freitagsmarkt.domain.components.SafetyAndSecurity;
import auto.freitagsmarkt.dto.components.SafetyAndSecurityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SafetyAndSecurityMapper {
    SafetyAndSecurityMapper INSTANCE = Mappers.getMapper(SafetyAndSecurityMapper.class);
    SafetyAndSecurityDTO toSafetyAndSecurityDTO(SafetyAndSecurity safetyAndSecurity);
    SafetyAndSecurity toSafetyAndSecurity(SafetyAndSecurityDTO safetyAndSecurityDTO);
}
