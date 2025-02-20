package auto.freitagsmarkt.service.otherComponents;

import auto.freitagsmarkt.dto.components.BrakesDTO;

public interface BrakesService {
    BrakesDTO addBrakes(BrakesDTO brakesDTO);
    BrakesDTO findBrakesById(Long id);
    BrakesDTO updateBrakesById(Long id,BrakesDTO brakesDTO);
}
