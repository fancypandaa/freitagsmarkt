package auto.freitagsmarkt.service;


import auto.freitagsmarkt.dto.car.specs.FuelDTO;

public interface FuelService {
    FuelDTO addFuelInfo(FuelDTO fuelDTO);
    FuelDTO findFuelById(Long fuelId);

}
