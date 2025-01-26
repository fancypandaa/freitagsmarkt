package auto.cc.info.mapper.specs;

import auto.cc.info.domain.Fuel;
import auto.cc.info.dto.car.specs.FuelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FuelMapper {
    FuelMapper INSTANCE = Mappers.getMapper(FuelMapper.class);
    Fuel fuelDTOtoFuel(FuelDTO fuelDTO);
    FuelDTO fuelToFuelDTO(Fuel fuel);

}
