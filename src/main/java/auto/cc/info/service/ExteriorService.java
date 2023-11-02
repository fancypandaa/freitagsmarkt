package auto.cc.info.service;

import auto.cc.info.commands.ExteriorCommand;
import auto.cc.info.commands.ExteriorEquipmentCommand;
import auto.cc.info.commands.custom.IExteriorCustom;

import java.util.List;

public interface ExteriorService {
    ExteriorEquipmentCommand createExteriorEquip(ExteriorEquipmentCommand exteriorEquipmentCommand);
    ExteriorCommand createExterior(ExteriorCommand exteriorCommand);
    ExteriorCommand findByExteriorId(Long id);
    List<IExteriorCustom> getChassisTypesByGroups();

}
