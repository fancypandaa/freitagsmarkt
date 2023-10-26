package auto.cc.info.converters;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.domain.Ads;
import auto.cc.info.domain.Seller;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class AdsCommandToAds implements Converter<AdsCommand, Ads> {
    private final CarCommandToCar carCommandToCar;

    public AdsCommandToAds(CarCommandToCar carCommandToCar) {
        this.carCommandToCar = carCommandToCar;
    }

    @Synchronized
    @Nullable
    @Override
    public Ads convert(AdsCommand source) {
        if (source == null) {
            return null;
        }
        final Ads ads= new Ads();
        ads.setId(source.getId());
        ads.setPublished(source.getPublished());
        ads.setStatus(source.getStatus());
        ads.setDaysOfSale(source.getDaysOfSale());
        if(source.getSellerId()!= null){
            Seller seller = new Seller();
            seller.setId(source.getSellerId());
            ads.setSeller(seller);
            seller.addAdsInfo(ads);
        }
        ads.setCar(carCommandToCar.convert(source.getCarCommand()));
        return ads;
    }
}
