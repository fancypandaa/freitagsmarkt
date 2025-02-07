package auto.freitagsmarkt.service.components;

import auto.freitagsmarkt.dto.components.InteriorDTO;

public interface InteriorService {
    InteriorDTO createInterior(InteriorDTO interiorDTO);
    InteriorDTO findInteriorById(Long id);

}
