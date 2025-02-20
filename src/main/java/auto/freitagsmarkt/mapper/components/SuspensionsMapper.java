package auto.freitagsmarkt.mapper.components;

import auto.freitagsmarkt.domain.othersComponents.Suspensions;
import auto.freitagsmarkt.dto.components.SuspensionsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SuspensionsMapper {
    SuspensionsMapper INSTANCE = Mappers.getMapper(SuspensionsMapper.class);
    Suspensions toSuspensions(SuspensionsDTO suspensionsDTO);
    SuspensionsDTO toSuspensionsDTO(Suspensions suspensions);

}
