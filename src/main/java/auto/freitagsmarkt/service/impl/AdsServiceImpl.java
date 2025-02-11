package auto.freitagsmarkt.service.impl;

import auto.freitagsmarkt.domain.Ads;
import auto.freitagsmarkt.dto.AdsDTO;
import auto.freitagsmarkt.mapper.AdsMapper;
import auto.freitagsmarkt.repository.AdsRepository;
import auto.freitagsmarkt.service.AdsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class AdsServiceImpl implements AdsService {
    private AdsRepository adsRepository;
    private AdsMapper adsMapper;
    private final static Logger log = LoggerFactory.getLogger(AdsServiceImpl.class);
    public AdsServiceImpl(AdsRepository adsRepository, AdsMapper adsMapper) {
        this.adsRepository = adsRepository;
        this.adsMapper = adsMapper;
    }

    @Override
    public List<AdsDTO> listAllAds(int page, int size) {
        Page<Ads> adsList = adsRepository.findAll(PageRequest.of(page,size));
        if(adsList.getTotalElements()<=0){
            return Collections.EMPTY_LIST;
        }
        return adsMapper.toAdsListDTO(adsList.getContent());
    }

    @Override
    public AdsDTO createNewAd(AdsDTO adsDTO) {
        return Optional.ofNullable(adsDTO)
                .map(adsMapper::toAd)
                .map(adsRepository::save)
                .map(adsMapper::toAdDTO)
                .orElseThrow(()-> new RuntimeException("Ads cannot created!!"));
    }

    @Override
    public AdsDTO findAdById(Long adId) {
        return adsRepository.findById(adId)
                .map(adsMapper::toAdDTO)
                .orElseThrow(() -> new RuntimeException("Ad Not Found"));
    }

    @Override
    public AdsDTO updateAd(Long adId, AdsDTO adsDTO) {
        Ads ads = adsRepository.findById(adId).
                orElseThrow(() -> new RuntimeException("Ad not found"));
        adsMapper.updateAdsFromAdsDTO(adsDTO,ads);
        return adsMapper.toAdDTO(adsRepository.save(ads));
    }

    @Override
    public Boolean removeAdById(Long adId) {
        if(adsRepository.existsById(adId)){
            adsRepository.deleteById(adId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
