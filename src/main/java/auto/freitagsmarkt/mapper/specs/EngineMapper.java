package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.carSpecs.Engine;
import auto.freitagsmarkt.dto.car.specs.EngineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EngineMapper {
    EngineMapper INSTANCE = Mappers.getMapper(EngineMapper.class);
    Engine toEngine(EngineDTO engineDTO);
    EngineDTO toEngineDTO(Engine engine);
    List<EngineDTO> engineListDTO(List<Engine> engineList);
    void updateEngineFromEngineDTO(EngineDTO engineDTO, @TargetType Engine engine);
}
