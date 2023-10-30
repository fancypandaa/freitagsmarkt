package auto.cc.info.converters;

import auto.cc.info.commands.ExteriorCommand;
import auto.cc.info.domain.Exterior;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ExteriorToExteriorCommand implements Converter<Exterior,ExteriorCommand> {
    private final ExEquipmentToExEquipmentCommand equipmentCommand;

    public ExteriorToExteriorCommand(ExEquipmentToExEquipmentCommand equipmentCommand) {
        this.equipmentCommand = equipmentCommand;
    }
    @Override
    @Nullable
    @Synchronized
    public ExteriorCommand convert(Exterior source) {
        if(source == null) return null;
        final ExteriorCommand exteriorCommand = new ExteriorCommand();
        exteriorCommand.setId(source.getId());
        exteriorCommand.setChassis(source.getChassis());
        exteriorCommand.setChassisOptions(source.getChassisOptions());
        exteriorCommand.setNumberOfDoors(source.getNumberOfDoors());
        exteriorCommand.setFrontDoors(source.getFrontDoors());
        exteriorCommand.setBackDoors(source.getBackDoors());
        exteriorCommand.setPlatform(source.getPlatform());
        exteriorCommand.setExteriorEquipment(equipmentCommand.convert(source.getExteriorEquipment()));
        return exteriorCommand;
    }
}
