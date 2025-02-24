package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.specs.Features;
import auto.freitagsmarkt.dto.specs.FeaturesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FeaturesMapper {
    FeaturesMapper INSTANCE = Mappers.getMapper(FeaturesMapper.class);
    Features toFeatures(FeaturesDTO featuresDTO);
    FeaturesDTO toFeaturesDTO(Features features);
}
