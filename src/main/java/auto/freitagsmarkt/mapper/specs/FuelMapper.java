package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.carSpecs.Fuel;
import auto.freitagsmarkt.dto.car.specs.FuelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FuelMapper {
    FuelMapper INSTANCE = Mappers.getMapper(FuelMapper.class);
    Fuel fuelDTOtoFuel(FuelDTO fuelDTO);
    FuelDTO fuelToFuelDTO(Fuel fuel);

}
