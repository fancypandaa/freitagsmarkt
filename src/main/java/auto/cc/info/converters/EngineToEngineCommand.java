package auto.cc.info.converters;

import auto.cc.info.commands.EngineCommand;
import auto.cc.info.domain.Engine;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component

public class EngineToEngineCommand implements Converter<Engine,EngineCommand> {
    private final BrakesToBrakesCommand brakesCommand;
    private final SuspensionsToSuspensionsCommand suspensionsCommand;
    private final  FuelToFuelCommand fuelCommand;
    private final TransmissionToTransmissionCommand transmissionCommand;

    public EngineToEngineCommand(BrakesToBrakesCommand brakesCommand, SuspensionsToSuspensionsCommand suspensionsCommand, FuelToFuelCommand fuelCommand, TransmissionToTransmissionCommand transmissionCommand) {
        this.brakesCommand = brakesCommand;
        this.suspensionsCommand = suspensionsCommand;
        this.fuelCommand = fuelCommand;
        this.transmissionCommand = transmissionCommand;
    }


    @Override
    @Synchronized
    @Nullable
    public EngineCommand convert(Engine source) {
        if (source == null) {
            return null;
        }
        final EngineCommand engineCommand = new EngineCommand();
        engineCommand.setId(source.getId());
        engineCommand.setEngineConfiguration(source.getEngineConfiguration());
        engineCommand.setEngineFluids(source.getEngineFluids());
        engineCommand.setServiceIntervals(source.getServiceIntervals());
        engineCommand.setEngineSpecification(source.getEngineSpecification());
        engineCommand.setBrakes(brakesCommand.convert(source.getBrakes()));
        engineCommand.setSuspensionsCommand(suspensionsCommand.convert(source.getSuspensions()));
        engineCommand.setFuel(fuelCommand.convert(source.getFuel()));
        engineCommand.setTransmission(transmissionCommand.convert(source.getTransmission()));
        return engineCommand;
    }
}
