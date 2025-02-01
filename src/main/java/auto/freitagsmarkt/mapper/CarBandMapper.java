package auto.cc.info.mapper;

import auto.cc.info.domain.carSpecs.CarBrand;
import auto.cc.info.dto.car.CarBrandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarBandMapper {
    CarBandMapper INSTANCE = Mappers.getMapper(CarBandMapper.class);
    CarBrand carBrandDTOtoCarBrand(CarBrandDTO carBrandDTO);
    CarBrandDTO carBrandToCarBrandDTO(CarBrand carBrand);

}
