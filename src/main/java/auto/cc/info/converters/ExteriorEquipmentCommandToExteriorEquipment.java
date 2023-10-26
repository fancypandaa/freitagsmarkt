package auto.cc.info.converters;

import auto.cc.info.commands.ExteriorEquipmentCommand;
import auto.cc.info.domain.ExteriorEquipment;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ExteriorEquipmentCommandToExteriorEquipment implements Converter<ExteriorEquipmentCommand,ExteriorEquipment> {
    @Override
    @Nullable
    @Synchronized
    public ExteriorEquipment convert(ExteriorEquipmentCommand source) {
        if (source == null) {
            return null;
        }
        final ExteriorEquipment exteriorEquipment = new ExteriorEquipment();
        exteriorEquipment.setId(source.getId());
        exteriorEquipment.setSideMirrors(source.getSideMirrors());
        exteriorEquipment.setWindscreenWipers(source.getWindscreenWipers());
        exteriorEquipment.setWindows(source.getWindows());
        exteriorEquipment.setLights(source.getLights());
        exteriorEquipment.setRimsAndTires(source.getRimsAndTires());
        exteriorEquipment.setOtherEquipments(source.getOtherEquipments());
        exteriorEquipment.setTireDimensions(source.getTireDimensions());
        exteriorEquipment.setRoofColour(source.getRoofColour());
        exteriorEquipment.setAccent(source.getAccent());
        exteriorEquipment.setDoorHandles(source.getDoorHandles());
        return exteriorEquipment;
    }
}
