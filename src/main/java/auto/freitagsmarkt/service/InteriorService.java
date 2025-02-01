package auto.cc.info.service;

import auto.cc.info.dto.car.otherComponents.InteriorDTO;
import auto.cc.info.dto.otherComponents.InteriorEquipmentsCommand;

public interface InteriorService {
    InteriorEquipmentsCommand createInteriorEquip(InteriorEquipmentsCommand interiorEquipmentsCommand);
    InteriorDTO createInterior(InteriorDTO interiorCommand);
    InteriorDTO findInteriorById(Long id);

}
