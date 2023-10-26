package auto.cc.info.service;

import auto.cc.info.commands.FuelCommand;
import auto.cc.info.converters.FuelCommandToFuel;
import auto.cc.info.converters.FuelToFuelCommand;
import auto.cc.info.domain.Fuel;
import auto.cc.info.repository.FuelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class FuelServiceImpl implements FuelService{
    private final FuelRepository fuelRepository;
    private final FuelCommandToFuel fuelCommandToFuel;
    private final FuelToFuelCommand fuelToFuelCommand;

    public FuelServiceImpl(FuelRepository fuelRepository, FuelCommandToFuel fuelCommandToFuel, FuelToFuelCommand fuelToFuelCommand) {
        this.fuelRepository = fuelRepository;
        this.fuelCommandToFuel = fuelCommandToFuel;
        this.fuelToFuelCommand = fuelToFuelCommand;
    }

    @Override
    @Transactional
    public FuelCommand addFuelInfo(FuelCommand fuelCommand) {

        Fuel fuel= fuelCommandToFuel.convert(fuelCommand);
        fuelRepository.save(fuel);
        return fuelCommand;
    }
}
