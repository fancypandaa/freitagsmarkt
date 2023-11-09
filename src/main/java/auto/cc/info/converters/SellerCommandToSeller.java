package auto.cc.info.converters;

import auto.cc.info.commands.SellerCommand;
import auto.cc.info.domain.Seller;
import auto.cc.info.domain.SellerType;
import auto.cc.info.domain.user.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class SellerCommandToSeller implements Converter<SellerCommand, Seller> {
    private final AdsCommandToAds commandToAds;
    public SellerCommandToSeller(AdsCommandToAds commandToAds) {
        this.commandToAds = commandToAds;
    }

    @Synchronized
    @Nullable
    @Override
    public Seller convert(SellerCommand source) {
        if (source == null) {
            return null;
        }
        final Seller seller=new Seller();
        seller.setId(source.getId());
        seller.setSellerWebsite(source.getSellerWebsite());
        seller.setName(source.getName());
        seller.setPhone(source.getPhone());
        seller.setType(source.getType());
        if(source.getAds() != null && source.getAds().size()>0){
            source.getAds().forEach(
                    ad ->{
                    seller.getAds().add(commandToAds.convert(ad));
                    }
            );
        }
        if(source.getUserId() != null){
            User user = new User();
            user.setId(source.getUserId());
            seller.setUser(user);
        }

        return seller;
    }


}
