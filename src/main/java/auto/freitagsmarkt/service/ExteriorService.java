package auto.cc.info.service;

import auto.cc.info.dto.car.otherComponents.ExteriorDTO;
import auto.cc.info.dto.otherComponents.ExteriorEquipmentCommand;
import auto.cc.info.dto.custom.IExteriorCustom;

import java.util.List;

public interface ExteriorService {
    ExteriorEquipmentCommand createExteriorEquip(ExteriorEquipmentCommand exteriorEquipmentCommand);
    ExteriorDTO createExterior(ExteriorDTO exteriorCommand);
    ExteriorDTO findByExteriorId(Long id);
    List<IExteriorCustom> getChassisTypesByGroups();

}
