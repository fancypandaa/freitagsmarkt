package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.carSpecs.Exterior;
import auto.freitagsmarkt.dto.car.otherComponents.ExteriorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExteriorMapper {
    ExteriorMapper INSTANCE = Mappers.getMapper(ExteriorMapper.class);
    Exterior toExterior(ExteriorDTO exteriorDTO);
    ExteriorDTO toExteriorDTO(Exterior exterior);
}
