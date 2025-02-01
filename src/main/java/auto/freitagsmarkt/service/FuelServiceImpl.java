package auto.cc.info.service;

import auto.cc.info.dto.carSpecs.FuelCommand;
import auto.cc.info.dto.custom.IFuelCustom;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FuelServiceImpl implements FuelService{

    @Override
    public FuelCommand addFuelInfo(FuelCommand fuelCommand) {
        return null;
    }

    @Override
    public List<IFuelCustom> getFuelTypesByGroups() {
        return null;
    }
}
