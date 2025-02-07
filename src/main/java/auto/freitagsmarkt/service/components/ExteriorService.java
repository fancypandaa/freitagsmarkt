package auto.freitagsmarkt.service.components;

import auto.freitagsmarkt.dto.components.ExteriorDTO;

public interface ExteriorService {
    ExteriorDTO createExterior(ExteriorDTO exteriorCommand);
    ExteriorDTO findByExteriorId(Long id);

}
