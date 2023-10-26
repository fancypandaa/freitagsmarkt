package auto.cc.info.converters;

import auto.cc.info.commands.DimensionsAndWeightCommand;
import auto.cc.info.domain.DimensionsAndWeight;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class DimensionsAndWeightCommandToDimensionsAndWeight implements Converter<DimensionsAndWeightCommand, DimensionsAndWeight> {
    @Override
    @Synchronized
    @Nullable
    public DimensionsAndWeight convert(DimensionsAndWeightCommand source) {
        if (source == null) {
            return null;
        }
        final DimensionsAndWeight dimensionsAndWeight= new DimensionsAndWeight();
        dimensionsAndWeight.setId(source.getId());
        dimensionsAndWeight.setHeight(source.getHeight());
        dimensionsAndWeight.setWeight(source.getWeight());
        dimensionsAndWeight.setLength(source.getLength());
        dimensionsAndWeight.setWidth(source.getWidth());
        dimensionsAndWeight.setTrackFront(source.getTrackFront());
        dimensionsAndWeight.setTrackRear(source.getTrackRear());
        dimensionsAndWeight.setGroundClearance(source.getGroundClearance());
        dimensionsAndWeight.setWidthWithMirrors(source.getWidthWithMirrors());
        dimensionsAndWeight.setInterior(source.getInterior());
        dimensionsAndWeight.setTurningCircle(source.getTurningCircle());
        dimensionsAndWeight.setOverhangFront(source.getOverhangFront());
        dimensionsAndWeight.setOverhangRear(source.getOverhangRear());
        dimensionsAndWeight.setWheelBase(source.getWheelBase());
        return dimensionsAndWeight;
    }
}
