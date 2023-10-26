package auto.cc.info.converters;

import auto.cc.info.commands.*;
import auto.cc.info.domain.Engine;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component

public class EngineCommandToEngine implements Converter<EngineCommand, Engine> {
    private final BrakesCommandToBrakes brakesCommandToBrakes;
    private final SuspensionsCommandToSuspensions suspensionsCommandToSuspensions;
    private final  FuelCommandToFuel fuelCommandToFuel;
    private final TransmissionCommandToTransmission transmissionCommandToTransmission;

    public EngineCommandToEngine(BrakesCommandToBrakes brakesCommandToBrakes, SuspensionsCommandToSuspensions suspensionsCommandToSuspensions, FuelCommandToFuel fuelCommandToFuel, TransmissionCommandToTransmission transmissionCommandToTransmission) {
        this.brakesCommandToBrakes = brakesCommandToBrakes;
        this.suspensionsCommandToSuspensions = suspensionsCommandToSuspensions;
        this.fuelCommandToFuel = fuelCommandToFuel;
        this.transmissionCommandToTransmission = transmissionCommandToTransmission;
    }

    @Override
    @Synchronized
    @Nullable
    public Engine convert(EngineCommand source) {
        if (source == null) {
            return null;
        }
        final Engine engine = new Engine();
        engine.setId(source.getId());
        engine.setEngineConfiguration(source.getEngineConfiguration());
        engine.setEngineFluids(source.getEngineFluids());
        engine.setServiceIntervals(source.getServiceIntervals());
        engine.setEngineSpecification(source.getEngineSpecification());
        engine.setBrakes(brakesCommandToBrakes.convert(source.getBrakes()));
        engine.setSuspensions(suspensionsCommandToSuspensions.convert(source.getSuspensionsCommand()));
        engine.setFuel(fuelCommandToFuel.convert(source.getFuel()));
        engine.setTransmission(transmissionCommandToTransmission.convert(source.getTransmission()));
        return engine;
    }
}
