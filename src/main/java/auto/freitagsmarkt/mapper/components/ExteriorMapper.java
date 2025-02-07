package auto.freitagsmarkt.mapper.components;

import auto.freitagsmarkt.domain.components.Exterior;
import auto.freitagsmarkt.dto.components.ExteriorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExteriorMapper {
    ExteriorMapper INSTANCE = Mappers.getMapper(ExteriorMapper.class);
    Exterior toExterior(ExteriorDTO exteriorDTO);
    ExteriorDTO toExteriorDTO(Exterior exterior);
}
