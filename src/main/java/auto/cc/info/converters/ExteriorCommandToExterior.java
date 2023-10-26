package auto.cc.info.converters;

import auto.cc.info.commands.ExteriorCommand;
import auto.cc.info.domain.Exterior;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Component
public class ExteriorCommandToExterior implements Converter<ExteriorCommand, Exterior> {
    private final ExteriorEquipmentCommandToExteriorEquipment commandToExteriorEquipment;

    public ExteriorCommandToExterior(ExteriorEquipmentCommandToExteriorEquipment commandToExteriorEquipment) {
        this.commandToExteriorEquipment = commandToExteriorEquipment;
    }

    @Override
    @Nullable
    @Transactional
    public Exterior convert(ExteriorCommand source) {
        if(source == null) return null;

        final Exterior exterior= new Exterior();
        exterior.setId(source.getId());
        exterior.setChassis(source.getChassis());
        exterior.setChassisOptions(source.getChassisOptions());
        exterior.setNumberOfDoors(source.getNumberOfDoors());
        exterior.setFrontDoors(source.getFrontDoors());
        exterior.setBackDoors(source.getBackDoors());
        exterior.setPlatform(source.getPlatform());
        exterior.setExteriorEquipment(commandToExteriorEquipment.convert(source.getExteriorEquipment()));
        return exterior;
    }
}
