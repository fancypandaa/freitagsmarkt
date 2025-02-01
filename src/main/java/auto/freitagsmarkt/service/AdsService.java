package auto.cc.info.service;

import auto.cc.info.dto.AdsDTO;
import org.springframework.data.domain.Page;

public interface AdsService {
    Page<AdsDTO> listAllAds(int page, int size);
    AdsDTO createNewAds(Long sellerId, AdsDTO ads);
    AdsDTO findAdsById(Long adsId);
    AdsDTO updateAds(Long sellerId, Long adsId, AdsDTO adsCommand);
    void removeAdsById(Long adsId);
}
