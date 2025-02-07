package auto.freitagsmarkt.service.specs;

import auto.freitagsmarkt.dto.specs.BrakesDTO;

public interface BrakesService {
    BrakesDTO addBrakes(BrakesDTO brakesDTO);
    BrakesDTO findBrakesById(Long id);
    BrakesDTO updateBrakesById(Long id,BrakesDTO brakesDTO);
}
