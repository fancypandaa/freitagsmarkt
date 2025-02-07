package auto.freitagsmarkt.service;

import auto.freitagsmarkt.dto.car.otherComponents.ExteriorEquipmentDTO;

public interface ExteriorEquipmentService {
    ExteriorEquipmentDTO findExteriorEquipmentById(Long exId);
    ExteriorEquipmentDTO createExteriorEquipment(ExteriorEquipmentDTO exteriorEquipmentDTO);
}
