package auto.freitagsmarkt.service;

import auto.freitagsmarkt.dto.AdsDTO;

import java.util.List;

public interface AdsService {
    List<AdsDTO> listAllAds(int page, int size);
    AdsDTO createNewAd(AdsDTO adsDTO);
    AdsDTO findAdById(Long adId);
    AdsDTO updateAd(Long adId, AdsDTO adsDTO);
    Boolean removeAdById(Long adId);
}
