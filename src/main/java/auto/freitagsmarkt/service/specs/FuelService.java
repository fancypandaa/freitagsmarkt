package auto.freitagsmarkt.service.specs;


import auto.freitagsmarkt.dto.specs.FuelDTO;

public interface FuelService {
    FuelDTO addFuelInfo(FuelDTO fuelDTO);
    FuelDTO findFuelById(Long fuelId);

}
