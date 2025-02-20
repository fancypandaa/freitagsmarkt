package auto.freitagsmarkt.service.otherComponents;

import auto.freitagsmarkt.dto.components.InteriorEquipmentsDTO;

public interface InteriorEquipmentsService {
    InteriorEquipmentsDTO createNewInteriorEquipment(InteriorEquipmentsDTO interiorEquipmentsDTO);
    InteriorEquipmentsDTO findInteriorEquipmentById(Long id);

}
