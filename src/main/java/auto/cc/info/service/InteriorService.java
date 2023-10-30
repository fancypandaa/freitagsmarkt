package auto.cc.info.service;

import auto.cc.info.commands.InteriorCommand;
import auto.cc.info.commands.InteriorEquipmentsCommand;

public interface InteriorService {
    InteriorEquipmentsCommand createInteriorEquip(InteriorEquipmentsCommand interiorEquipmentsCommand);
    InteriorCommand createInterior(InteriorCommand interiorCommand);
    InteriorCommand findInteriorById(Long id);

}
