package auto.freitagsmarkt.mapper.components;

import auto.freitagsmarkt.domain.othersComponents.InteriorEquipments;
import auto.freitagsmarkt.dto.components.InteriorEquipmentsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InteriorEquipmentsMapper {
    InteriorEquipmentsMapper INSTANCE = Mappers.getMapper(InteriorEquipmentsMapper.class);
    InteriorEquipmentsDTO toInteriorEquipmentsDTO(InteriorEquipments interiorEquipments);
    InteriorEquipments toInteriorEquipments(InteriorEquipmentsDTO interiorEquipmentsDTO);
}
