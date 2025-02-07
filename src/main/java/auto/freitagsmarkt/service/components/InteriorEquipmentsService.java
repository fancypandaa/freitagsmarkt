package auto.freitagsmarkt.service.components;

import auto.freitagsmarkt.dto.components.InteriorEquipmentsDTO;

public interface InteriorEquipmentsService {
    InteriorEquipmentsDTO createNewInteriorEquipment(InteriorEquipmentsDTO interiorEquipmentsDTO);
    InteriorEquipmentsDTO findInteriorEquipmentById(Long id);

}
