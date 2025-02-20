package auto.freitagsmarkt.service.specs;

import auto.freitagsmarkt.dto.specs.EngineDTO;
import java.util.List;
public interface EngineService {
    EngineDTO addNewEngineDetails(EngineDTO engineCommand);
    List<EngineDTO> listEngines(int page,int size);
    EngineDTO findEngineById(Long engineId);
    Boolean removeEngineById(Long engineId);
}
