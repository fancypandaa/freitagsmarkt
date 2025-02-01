package auto.cc.info.mapper.specs;

import auto.cc.info.domain.carSpecs.Brakes;
import auto.cc.info.dto.car.specs.BrakesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrakesMapper {
    BrakesMapper INSTANCE = Mappers.getMapper(BrakesMapper.class);
    Brakes brakesDTOtoBrakes(BrakesDTO brakesDTO);
    BrakesDTO brakesToBrakesDTO(Brakes brakes);
    void updateBrakesFromBrakesDTO(BrakesDTO brakesDTO, @TargetType Brakes brakes);
}
