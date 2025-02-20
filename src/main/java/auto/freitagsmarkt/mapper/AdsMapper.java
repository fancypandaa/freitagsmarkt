package auto.freitagsmarkt.mapper;

import auto.freitagsmarkt.domain.Ads;
import auto.freitagsmarkt.dto.AdsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdsMapper {
    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);
    Ads toAd(AdsDTO adDTO);
    AdsDTO toAdDTO(Ads ad);
    List<AdsDTO> toAdsListDTO(List<Ads> ads);
    List<Ads> toAdsList(List<AdsDTO> adsDTOList);
    void updateAdsFromAdsDTO(AdsDTO adsDTO, @MappingTarget Ads ads);
}
