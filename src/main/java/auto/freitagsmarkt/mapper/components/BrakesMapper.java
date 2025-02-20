package auto.freitagsmarkt.mapper.components;

import auto.freitagsmarkt.domain.othersComponents.Brakes;
import auto.freitagsmarkt.dto.components.BrakesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrakesMapper {
    BrakesMapper INSTANCE = Mappers.getMapper(BrakesMapper.class);
    Brakes toBrakes(BrakesDTO brakesDTO);
    BrakesDTO toBrakesDTO(Brakes brakes);
    void updateBrakesFromBrakesDTO(BrakesDTO brakesDTO, @MappingTarget Brakes brakes);
}
