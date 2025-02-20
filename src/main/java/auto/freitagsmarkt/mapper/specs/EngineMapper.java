package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.specs.Engine;
import auto.freitagsmarkt.dto.specs.EngineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EngineMapper {
    EngineMapper INSTANCE = Mappers.getMapper(EngineMapper.class);
    Engine toEngine(EngineDTO engineDTO);
    EngineDTO toEngineDTO(Engine engine);
    List<EngineDTO> engineListDTO(List<Engine> engineList);
    void updateEngineFromEngineDTO(EngineDTO engineDTO, @MappingTarget Engine engine);
}
