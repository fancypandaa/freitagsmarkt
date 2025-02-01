package auto.cc.info.service;

import auto.cc.info.dto.car.otherComponents.ExteriorDTO;
import auto.cc.info.dto.otherComponents.ExteriorEquipmentCommand;
import auto.cc.info.dto.custom.IExteriorCustom;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExteriorServiceImpl implements ExteriorService{

    @Override
    public ExteriorEquipmentCommand createExteriorEquip(ExteriorEquipmentCommand exteriorEquipmentCommand) {
        return null;
    }

    @Override
    public ExteriorDTO createExterior(ExteriorDTO exteriorCommand) {
        return null;
    }

    @Override
    public ExteriorDTO findByExteriorId(Long id) {
        return null;
    }

    @Override
    public List<IExteriorCustom> getChassisTypesByGroups() {
        return null;
    }
}
