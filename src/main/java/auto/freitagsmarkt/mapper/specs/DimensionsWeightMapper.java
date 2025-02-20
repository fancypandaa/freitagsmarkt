package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.specs.DimensionsWeight;
import auto.freitagsmarkt.dto.specs.DimensionsWeightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DimensionsWeightMapper {
    DimensionsWeightMapper INSTANCE = Mappers.getMapper(DimensionsWeightMapper.class);
    DimensionsWeightDTO toDimensionsWeightDTO(DimensionsWeight dimensionsWeight);
    DimensionsWeight toDimensionWeight(DimensionsWeightDTO dimensionsWeightDTO);
    void updateDimensionsWeightFromDTO(DimensionsWeightDTO weightDTO , @MappingTarget DimensionsWeight dimensionsWeight);
}
