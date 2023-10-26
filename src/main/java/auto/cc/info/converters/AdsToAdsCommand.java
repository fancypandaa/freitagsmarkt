package auto.cc.info.converters;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.domain.Ads;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class AdsToAdsCommand implements Converter<Ads,AdsCommand> {
    private final CarToCarCommand carToCarCommand;

    public AdsToAdsCommand(CarToCarCommand carToCarCommand) {
        this.carToCarCommand = carToCarCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public AdsCommand convert(Ads source) {
        if (source == null) {
            return null;
        }
        final AdsCommand ads= new AdsCommand();
        ads.setId(source.getId());
        ads.setPublished(source.getPublished());
        ads.setStatus(source.getStatus());
        ads.setDaysOfSale(source.getDaysOfSale());
        if(source.getSeller().getId()!= null){
            ads.setSellerId(source.getSeller().getId());
        }
        ads.setCarCommand(carToCarCommand.convert(source.getCar()));
        return ads;
    }
}
