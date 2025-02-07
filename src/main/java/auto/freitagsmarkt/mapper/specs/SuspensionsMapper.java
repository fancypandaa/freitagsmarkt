package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.carSpecs.Suspensions;
import auto.freitagsmarkt.dto.specs.SuspensionsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SuspensionsMapper {
    SuspensionsMapper INSTANCE = Mappers.getMapper(SuspensionsMapper.class);
    Suspensions toSuspensions(SuspensionsDTO suspensionsDTO);
    SuspensionsDTO toSuspensionsDTO(Suspensions suspensions);

}
