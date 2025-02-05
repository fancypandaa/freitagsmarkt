package auto.freitagsmarkt.mapper;

import auto.freitagsmarkt.domain.Car;
import auto.freitagsmarkt.dto.car.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.util.*;
@Mapper(componentModel = "spring")
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    Car toCar(CarDTO carDTO);
    CarDTO toCarDTO(Car car);
    List<CarDTO> toCarListDTO(List<Car> carList);
    void updateCarFromCarDTO(CarDTO carDTO , @MappingTarget Car car);
}
