package auto.freitagsmarkt.service;

import auto.freitagsmarkt.dto.car.specs.EngineDTO;
import java.util.List;
public interface EngineService {
    EngineDTO addNewEngineDetails(EngineDTO engineCommand);
    List<EngineDTO> listEngines(int page,int size);
    EngineDTO findEngineById(Long engineId);
    void removeEngineById(Long engineId);
}
