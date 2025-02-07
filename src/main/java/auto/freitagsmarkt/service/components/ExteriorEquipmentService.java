package auto.freitagsmarkt.service.components;

import auto.freitagsmarkt.dto.components.ExteriorEquipmentDTO;

public interface ExteriorEquipmentService {
    ExteriorEquipmentDTO findExteriorEquipmentById(Long exId);
    ExteriorEquipmentDTO createExteriorEquipment(ExteriorEquipmentDTO exteriorEquipmentDTO);
}
