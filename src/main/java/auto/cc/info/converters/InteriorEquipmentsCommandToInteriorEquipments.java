package auto.cc.info.converters;

import auto.cc.info.commands.InteriorEquipmentsCommand;
import auto.cc.info.domain.InteriorEquipments;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InteriorEquipmentsCommandToInteriorEquipments implements Converter<InteriorEquipmentsCommand, InteriorEquipments> {
    @Override
    @Transactional
    @Nullable
    public InteriorEquipments convert(InteriorEquipmentsCommand source) {
        if(source == null) return null;
        InteriorEquipments interiorEquipments= new InteriorEquipments();

        interiorEquipments.setId(source.getId());
        interiorEquipments.setSteeringWheels(source.getSteeringWheels());
        interiorEquipments.setTrunk(source.getTrunk());
        interiorEquipments.setDesign(source.getDesign());
        interiorEquipments.setSeats(source.getSeats());
        interiorEquipments.setRimsAndTires(source.getRimsAndTires());
        interiorEquipments.setOtherEquipments(source.getOtherEquipments());
        interiorEquipments.setTireDimensions(source.getTireDimensions());
        return interiorEquipments;
    }
}
