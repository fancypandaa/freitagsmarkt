package auto.freitagsmarkt.service;

import auto.freitagsmarkt.dto.car.otherComponents.ExteriorDTO;

public interface ExteriorService {
    ExteriorDTO createExterior(ExteriorDTO exteriorCommand);
    ExteriorDTO findByExteriorId(Long id);

}
