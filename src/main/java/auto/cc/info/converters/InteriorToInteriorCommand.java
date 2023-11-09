package auto.cc.info.converters;

import auto.cc.info.commands.InteriorCommand;
import auto.cc.info.domain.Interior;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class InteriorToInteriorCommand implements Converter<Interior,InteriorCommand> {
    private final InEquipmentsToInEquipmentsCommand interiorEquipmentsConverter;

    public InteriorToInteriorCommand(InEquipmentsToInEquipmentsCommand interiorEquipmentsConverter) {
        this.interiorEquipmentsConverter = interiorEquipmentsConverter;
    }
    @Override
    @Synchronized
    @Nullable
    public InteriorCommand convert(Interior source) {
        if(source==null) return null;
        final InteriorCommand interiorCommand = new InteriorCommand();
        interiorCommand.setId(source.getId());
        interiorCommand.setInstrumentCluster(source.getInstrumentCluster());
        interiorCommand.setConnectivity(source.getConnectivity());
        interiorCommand.setClimateControl(source.getClimateControl());
        interiorCommand.setDisplays(source.getDisplays());
        interiorCommand.setSpeakers(source.getSpeakers());
        interiorCommand.setRear_viewMirror(source.getRear_viewMirror());
        interiorCommand.setInteriorStorage(source.getInteriorStorage());
        interiorCommand.setLights(source.getLights());
        interiorCommand.setInteriorEquipments(interiorEquipmentsConverter.convert(source.getInteriorEquipments()));
        return interiorCommand;
    }
}
