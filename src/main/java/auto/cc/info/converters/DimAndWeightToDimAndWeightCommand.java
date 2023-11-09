package auto.cc.info.converters;

import auto.cc.info.commands.DimensionsAndWeightCommand;
import auto.cc.info.domain.DimensionsAndWeight;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class DimAndWeightToDimAndWeightCommand implements Converter<DimensionsAndWeight,DimensionsAndWeightCommand> {
    @Override
    @Synchronized
    @Nullable
    public DimensionsAndWeightCommand convert(DimensionsAndWeight source) {
        if (source == null) {
            return null;
        }
        final DimensionsAndWeightCommand dimensionsAndWeightCommand = new DimensionsAndWeightCommand();
        dimensionsAndWeightCommand.setId(source.getId());
        dimensionsAndWeightCommand.setHeight(source.getHeight());
        dimensionsAndWeightCommand.setWeight(source.getWeight());
        dimensionsAndWeightCommand.setLength(source.getLength());
        dimensionsAndWeightCommand.setWidth(source.getWidth());
        dimensionsAndWeightCommand.setTrackFront(source.getTrackFront());
        dimensionsAndWeightCommand.setTrackRear(source.getTrackRear());
        dimensionsAndWeightCommand.setGroundClearance(source.getGroundClearance());
        dimensionsAndWeightCommand.setWidthWithMirrors(source.getWidthWithMirrors());
        dimensionsAndWeightCommand.setInterior(source.getInterior());
        dimensionsAndWeightCommand.setTurningCircle(source.getTurningCircle());
        dimensionsAndWeightCommand.setOverhangFront(source.getOverhangFront());
        dimensionsAndWeightCommand.setOverhangRear(source.getOverhangRear());
        dimensionsAndWeightCommand.setWheelBase(source.getWheelBase());
        return dimensionsAndWeightCommand;
    }
}
