package auto.freitagsmarkt.mapper.components;

import auto.freitagsmarkt.domain.othersComponents.Fuel;
import auto.freitagsmarkt.dto.components.FuelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FuelMapper {
    FuelMapper INSTANCE = Mappers.getMapper(FuelMapper.class);
    Fuel toFuel(FuelDTO fuelDTO);
    FuelDTO toFuelDTO(Fuel fuel);
}
