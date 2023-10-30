package auto.cc.info.converters;

import auto.cc.info.commands.InteriorEquipmentsCommand;
import auto.cc.info.domain.InteriorEquipments;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class InEquipmentsToInEquipmentsCommand implements Converter<InteriorEquipments,InteriorEquipmentsCommand> {
    @Override
    @Synchronized
    @Nullable
    public InteriorEquipmentsCommand convert(InteriorEquipments source) {
        if(source == null) return null;
        InteriorEquipmentsCommand interiorEquipmentsCommand = new InteriorEquipmentsCommand();

        interiorEquipmentsCommand.setId(source.getId());
        interiorEquipmentsCommand.setSteeringWheels(source.getSteeringWheels());
        interiorEquipmentsCommand.setTrunk(source.getTrunk());
        interiorEquipmentsCommand.setDesign(source.getDesign());
        interiorEquipmentsCommand.setSeats(source.getSeats());
        interiorEquipmentsCommand.setRimsAndTires(source.getRimsAndTires());
        interiorEquipmentsCommand.setOtherEquipments(source.getOtherEquipments());
        interiorEquipmentsCommand.setTireDimensions(source.getTireDimensions());
        return interiorEquipmentsCommand;
    }
}
