package auto.cc.info.converters;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.commands.SellerCommand;
import auto.cc.info.domain.Ads;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.Seller;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SellerToSellerCommand implements Converter<Seller,SellerCommand> {
    private final AdsToAdsCommand adsCommand;
    private final CarToCarCommand carCommand;
    public SellerToSellerCommand(AdsToAdsCommand adsCommand, CarToCarCommand carCommand) {
        this.adsCommand = adsCommand;
        this.carCommand = carCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public SellerCommand convert(Seller source) {
        if (source == null) {
            return null;
        }
        final SellerCommand sellerCommand =new SellerCommand();
        sellerCommand.setId(source.getId());
        sellerCommand.setSellerWebsite(source.getSellerWebsite());
        sellerCommand.setName(source.getName());
        sellerCommand.setPhone(source.getPhone());
        sellerCommand.setType(source.getType().toString());
        if(source.getAds() != null && source.getAds().size() > 0){
            source.getAds().forEach(
                    (Ads ad) ->{
                    sellerCommand.getAds().add(adsCommand.convert(ad));
                    }
            );
        }
        if(source.getCars()!=null && source.getCars().size() > 0){
            source.getCars().forEach((Car car)
                     ->{
                        sellerCommand.getCars().add(carCommand.convert(car));
                    }
            );
        }

        return sellerCommand;
    }


}
