package auto.cc.info.converters;

import auto.cc.info.commands.FeaturesCommand;
import auto.cc.info.domain.Features;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class FeaturesCommandToFeatures implements Converter<FeaturesCommand, Features> {
    @Synchronized
    @Nullable
    @Override
    public Features convert(FeaturesCommand source) {
        if (source == null) {
            return null;
        }
        final Features features = new Features();
        features.setId(source.getId());
        features.setComfort(source.getComfort());
        features.setOthers(source.getOthers());
        features.setAccessories(source.getAccessories());
        return features;
    }
}
