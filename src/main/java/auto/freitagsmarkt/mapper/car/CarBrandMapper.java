package auto.freitagsmarkt.mapper.car;

import auto.freitagsmarkt.domain.car.CarBrand;
import auto.freitagsmarkt.dto.car.CarBrandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.util.List;
@Mapper(componentModel = "spring")
public interface CarBrandMapper {
    CarBrandMapper INSTANCE = Mappers.getMapper(CarBrandMapper.class);
    CarBrand toCarBrand(CarBrandDTO carBrandDTO);
    CarBrandDTO toCarBrandDTO(CarBrand carBrand);
    void updateCarBrandDto(CarBrandDTO carBrandDTO, @MappingTarget CarBrand carBrand);
    @Mapping(target = "cars",ignore = true)
    List<CarBrandDTO> toCarBrandListDTO(List<CarBrand> carBrandList);

}
