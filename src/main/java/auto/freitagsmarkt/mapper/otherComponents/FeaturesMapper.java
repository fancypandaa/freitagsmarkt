package auto.freitagsmarkt.mapper.otherComponents;

import auto.freitagsmarkt.domain.exCarComponents.Features;
import auto.freitagsmarkt.dto.car.otherComponents.FeaturesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FeaturesMapper {
    FeaturesMapper INSTANCE = Mappers.getMapper(FeaturesMapper.class);
    Features toFeatures(FeaturesDTO featuresDTO);
    FeaturesDTO toFeaturesDTO(Features features);
}
