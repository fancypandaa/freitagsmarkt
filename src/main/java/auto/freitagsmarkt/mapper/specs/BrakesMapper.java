package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.carSpecs.Brakes;
import auto.freitagsmarkt.dto.specs.BrakesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrakesMapper {
    BrakesMapper INSTANCE = Mappers.getMapper(BrakesMapper.class);
    Brakes toBrakes(BrakesDTO brakesDTO);
    BrakesDTO toBrakesDTO(Brakes brakes);
    void updateBrakesFromBrakesDTO(BrakesDTO brakesDTO, @TargetType Brakes brakes);
}
