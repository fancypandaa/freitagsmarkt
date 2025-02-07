package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.carSpecs.Fuel;
import auto.freitagsmarkt.dto.specs.FuelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FuelMapper {
    FuelMapper INSTANCE = Mappers.getMapper(FuelMapper.class);
    Fuel toFuel(FuelDTO fuelDTO);
    FuelDTO toFuelDTO(Fuel fuel);
}
