package auto.freitagsmarkt.service.otherComponents;


import auto.freitagsmarkt.dto.components.FuelDTO;

public interface FuelService {
    FuelDTO addFuelInfo(FuelDTO fuelDTO);
    FuelDTO findFuelById(Long fuelId);

}
