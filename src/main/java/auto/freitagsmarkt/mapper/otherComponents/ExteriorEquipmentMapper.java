package auto.freitagsmarkt.mapper.otherComponents;

import auto.freitagsmarkt.domain.exCarComponents.ExteriorEquipment;
import auto.freitagsmarkt.dto.car.otherComponents.ExteriorEquipmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExteriorEquipmentMapper {
    ExteriorEquipmentMapper INSTANCE = Mappers.getMapper(ExteriorEquipmentMapper.class);
    ExteriorEquipment toExteriorEquipment(ExteriorEquipmentDTO exteriorEquipmentDTO);
    ExteriorEquipmentDTO toExteriorEquipmentDTO(ExteriorEquipment exteriorEquipment);
}
