package auto.cc.info.service;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.domain.Ads;
import org.springframework.data.domain.Page;

public interface AdsService {
    Page<AdsCommand> listAllAds(int page, int size);
    AdsCommand createNewAds(AdsCommand ads);
    AdsCommand findAdsById(Long ads_id);
    void removeAdsById(Long ads_id);
}
