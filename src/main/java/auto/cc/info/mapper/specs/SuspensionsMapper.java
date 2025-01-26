package auto.cc.info.mapper.specs;

import auto.cc.info.domain.Suspensions;
import auto.cc.info.dto.car.specs.SuspensionsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SuspensionsMapper {
    SuspensionsMapper INSTANCE = Mappers.getMapper(SuspensionsMapper.class);
    Suspensions suspensionsDTOtoSuspensions(SuspensionsDTO suspensionsDTO);
    SuspensionsDTO suspensionsToSuspensionsDTO(Suspensions suspensions);

}
