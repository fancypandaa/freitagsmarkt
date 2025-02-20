package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.specs.Interior;
import auto.freitagsmarkt.dto.specs.InteriorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InteriorMapper {
    InteriorMapper INSTANCE = Mappers.getMapper(InteriorMapper.class);
    Interior toInterior(InteriorDTO interiorDTO);
    InteriorDTO toInteriorDTO(Interior interior);
}
