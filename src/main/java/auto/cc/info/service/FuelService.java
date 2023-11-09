package auto.cc.info.service;

import auto.cc.info.commands.FuelCommand;
import auto.cc.info.commands.custom.IFuelCustom;

import java.util.*;
public interface FuelService {
    FuelCommand addFuelInfo(FuelCommand fuelCommand);
    List<IFuelCustom> getFuelTypesByGroups();
}
