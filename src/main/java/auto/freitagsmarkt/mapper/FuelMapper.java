package auto.freitagsmarkt.mapper;

import auto.freitagsmarkt.domain.carSpecs.Fuel;
import auto.freitagsmarkt.dto.car.specs.FuelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FuelMapper {
    FuelMapper INSTANCE = Mappers.getMapper(FuelMapper.class);
    Fuel toFuel(FuelDTO fuelDTO);
    FuelDTO toFuelDTO(Fuel fuel);
}
