package auto.cc.info.service;

import auto.cc.info.dto.carSpecs.EngineCommand;
import org.springframework.data.domain.Page;

public interface EngineService {
    EngineCommand addNewEngineDetails(EngineCommand engineCommand);
    Page<EngineCommand> listEngines(int page,int size);
    void removeEngineById(Long engineId);
}
