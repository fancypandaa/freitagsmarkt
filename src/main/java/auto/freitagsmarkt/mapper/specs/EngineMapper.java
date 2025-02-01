package auto.cc.info.mapper.specs;

import auto.cc.info.domain.carSpecs.Engine;
import auto.cc.info.dto.car.specs.EngineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EngineMapper {
    EngineMapper INSTANCE = Mappers.getMapper(EngineMapper.class);
    Engine engineDTOtoEngine(EngineDTO engineDTO);
    EngineDTO engineToEngineDTO(Engine engine);
    void updateEngineFromEngineDTO(EngineDTO engineDTO, @TargetType Engine engine);
}
