package auto.cc.info.mapper.specs;

import auto.cc.info.domain.carSpecs.DimensionsWeight;
import auto.cc.info.dto.car.specs.DimensionsWeightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DimensionsWeightMapper {
    DimensionsWeightMapper INSTANCE = Mappers.getMapper(DimensionsWeightMapper.class);
    DimensionsWeight dimensionsWeightToDimensionsWeightDTO(DimensionsWeightDTO dimensionsWeightDTO);
    DimensionsWeightDTO dimensionsWeightDTOtoDimensionWeight(DimensionsWeight dimensionsWeight);
    void updateDimensionsWeightFromDTO(DimensionsWeightDTO weightDTO , @TargetType DimensionsWeight dimensionsWeight);
}
