package auto.cc.info.mapper;

import auto.cc.info.domain.Car;
import auto.cc.info.dto.car.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    Car carDTOtoCar(CarDTO carDTO);
    CarDTO carToCarDTO(Car car);
    void updateCarFromCarDTO(CarDTO carDTO , @MappingTarget Car car);
}
