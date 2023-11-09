package auto.cc.info.converters;

import auto.cc.info.commands.FeaturesCommand;
import auto.cc.info.domain.Features;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class FeaturesToFeaturesCommand implements Converter<Features,FeaturesCommand> {
    @Synchronized
    @Nullable
    @Override
    public FeaturesCommand convert(Features source) {
        if (source == null) {
            return null;
        }
        final FeaturesCommand featuresCommand = new FeaturesCommand();
        featuresCommand.setId(source.getId());
        featuresCommand.setComfort(source.getComfort());
        featuresCommand.setOthers(source.getOthers());
        featuresCommand.setAccessories(source.getAccessories());
        return featuresCommand;
    }
}
