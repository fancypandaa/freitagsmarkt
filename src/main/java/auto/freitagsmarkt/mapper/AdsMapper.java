package auto.cc.info.mapper;

import auto.cc.info.domain.Ads;
import auto.cc.info.dto.AdsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdsMapper {
    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);
    Ads adsToAdsDTO(AdsDTO adsDTO);
    AdsDTO adsDTOtoAds(Ads ads);
    void updateAdsFromAdsDTO(AdsDTO adsDTO, @MappingTarget Ads ads);
}
