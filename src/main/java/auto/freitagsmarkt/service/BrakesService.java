package auto.freitagsmarkt.service;

import auto.freitagsmarkt.dto.car.specs.BrakesDTO;

public interface BrakesService {
    BrakesDTO addBrakes(BrakesDTO brakesDTO);
    BrakesDTO findBrakesById(Long id);
    BrakesDTO updateBrakesById(Long id,BrakesDTO brakesDTO);
}
