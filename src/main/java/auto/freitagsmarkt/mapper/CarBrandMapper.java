package auto.freitagsmarkt.mapper;

import auto.freitagsmarkt.domain.carSpecs.CarBrand;
import auto.freitagsmarkt.dto.car.CarBrandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.util.List;
@Mapper(componentModel = "spring")
public interface CarBrandMapper {
    CarBrandMapper INSTANCE = Mappers.getMapper(CarBrandMapper.class);
    CarBrand toCarBrand(CarBrandDTO carBrandDTO);
    CarBrandDTO toCarBrandDTO(CarBrand carBrand);
    void updateCarBrandDto(CarBrandDTO carBrandDTO, @MappingTarget CarBrand carBrand);
    List<CarBrandDTO> toCarBrandListDTO(List<CarBrand> carBrandList);

}
