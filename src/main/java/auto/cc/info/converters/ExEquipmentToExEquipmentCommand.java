package auto.cc.info.converters;

import auto.cc.info.commands.ExteriorEquipmentCommand;
import auto.cc.info.domain.ExteriorEquipment;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ExEquipmentToExEquipmentCommand implements Converter<ExteriorEquipment,ExteriorEquipmentCommand> {
    @Override
    @Nullable
    @Synchronized
    public ExteriorEquipmentCommand convert(ExteriorEquipment source) {
        if (source == null) {
            return null;
        }
        final ExteriorEquipmentCommand exteriorEquipmentCommand = new ExteriorEquipmentCommand();
        exteriorEquipmentCommand.setId(source.getId());
        exteriorEquipmentCommand.setSideMirrors(source.getSideMirrors());
        exteriorEquipmentCommand.setWindscreenWipers(source.getWindscreenWipers());
        exteriorEquipmentCommand.setWindows(source.getWindows());
        exteriorEquipmentCommand.setLights(source.getLights());
        exteriorEquipmentCommand.setRimsAndTires(source.getRimsAndTires());
        exteriorEquipmentCommand.setOtherEquipments(source.getOtherEquipments());
        exteriorEquipmentCommand.setTireDimensions(source.getTireDimensions());
        exteriorEquipmentCommand.setRoofColour(source.getRoofColour());
        exteriorEquipmentCommand.setAccent(source.getAccent());
        exteriorEquipmentCommand.setDoorHandles(source.getDoorHandles());
        return exteriorEquipmentCommand;
    }
}
