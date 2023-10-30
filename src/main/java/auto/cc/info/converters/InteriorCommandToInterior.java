package auto.cc.info.converters;

import auto.cc.info.commands.InteriorCommand;
import auto.cc.info.domain.Interior;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InteriorCommandToInterior implements Converter<InteriorCommand, Interior> {
    private final InEquipmentsCommandToInEquipments interiorEquipmentsConverter;
    public InteriorCommandToInterior(InEquipmentsCommandToInEquipments interiorEquipmentsConverter) {
        this.interiorEquipmentsConverter = interiorEquipmentsConverter;
    }

    @Override
    @Synchronized
    @Nullable
    public Interior convert(InteriorCommand source) {
        if(source==null) return null;

        final Interior interior = new Interior();
        interior.setId(source.getId());
        interior.setInstrumentCluster(source.getInstrumentCluster());
        interior.setConnectivity(source.getConnectivity());
        interior.setClimateControl(source.getClimateControl());
        interior.setDisplays(source.getDisplays());
        interior.setSpeakers(source.getSpeakers());
        interior.setRear_viewMirror(source.getRear_viewMirror());
        interior.setInteriorStorage(source.getInteriorStorage());
        interior.setLights(source.getLights());
        interior.setInteriorEquipments(interiorEquipmentsConverter.convert(source.getInteriorEquipments()));
        return interior;
    }
}
