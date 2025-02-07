package auto.freitagsmarkt.mapper.components;

import auto.freitagsmarkt.domain.components.Interior;
import auto.freitagsmarkt.dto.components.InteriorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InteriorMapper {
    InteriorMapper INSTANCE = Mappers.getMapper(InteriorMapper.class);
    Interior toInterior(InteriorDTO interiorDTO);
    InteriorDTO toInteriorDTO(Interior interior);
}
