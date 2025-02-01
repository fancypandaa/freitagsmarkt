package auto.cc.info.service;


import auto.cc.info.dto.AdsDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AdsServiceImpl implements AdsService {
    
    @Override
    public Page<AdsDTO> listAllAds(int page, int size) {
        return null;
    }

    @Override
    public AdsDTO createNewAds(Long sellerId, AdsDTO ads) {
        return null;
    }

    @Override
    public AdsDTO findAdsById(Long adsId) {
        return null;
    }

    @Override
    public AdsDTO updateAds(Long sellerId, Long adsId, AdsDTO adsCommand) {
        return null;
    }

    @Override
    public void removeAdsById(Long adsId) {

    }
}
