package auto.freitagsmarkt.service.otherComponents;

import auto.freitagsmarkt.dto.components.ExteriorEquipmentDTO;

public interface ExteriorEquipmentService {
    ExteriorEquipmentDTO findExteriorEquipmentById(Long exId);
    ExteriorEquipmentDTO createExteriorEquipment(ExteriorEquipmentDTO exteriorEquipmentDTO);
}
