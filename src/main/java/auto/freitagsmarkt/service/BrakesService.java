package auto.cc.info.service;

import auto.cc.info.dto.car.specs.BrakesDTO;

public interface BrakesService {
    BrakesDTO addBrakes(BrakesDTO brakesCommand);
    BrakesDTO findBrakesById(Long id);

}
