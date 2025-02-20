package auto.freitagsmarkt.service.specs;

import auto.freitagsmarkt.dto.specs.InteriorDTO;

public interface InteriorService {
    InteriorDTO createInterior(InteriorDTO interiorDTO);
    InteriorDTO findInteriorById(Long id);

}
