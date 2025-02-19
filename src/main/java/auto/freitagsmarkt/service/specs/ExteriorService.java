package auto.freitagsmarkt.service.specs;

import auto.freitagsmarkt.dto.specs.ExteriorDTO;

public interface ExteriorService {
    ExteriorDTO createExterior(ExteriorDTO exteriorCommand);
    ExteriorDTO findByExteriorId(Long id);

}
