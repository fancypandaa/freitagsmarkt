package auto.cc.info.service;

import auto.cc.info.dto.carSpecs.FuelCommand;
import auto.cc.info.dto.custom.IFuelCustom;

import java.util.*;
public interface FuelService {
    FuelCommand addFuelInfo(FuelCommand fuelCommand);
    List<IFuelCustom> getFuelTypesByGroups();
}
