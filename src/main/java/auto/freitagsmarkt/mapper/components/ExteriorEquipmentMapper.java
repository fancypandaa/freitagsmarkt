package auto.freitagsmarkt.mapper.components;

import auto.freitagsmarkt.domain.components.ExteriorEquipment;
import auto.freitagsmarkt.dto.components.ExteriorEquipmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExteriorEquipmentMapper {
    ExteriorEquipmentMapper INSTANCE = Mappers.getMapper(ExteriorEquipmentMapper.class);
    ExteriorEquipment toExteriorEquipment(ExteriorEquipmentDTO exteriorEquipmentDTO);
    ExteriorEquipmentDTO toExteriorEquipmentDTO(ExteriorEquipment exteriorEquipment);
}
