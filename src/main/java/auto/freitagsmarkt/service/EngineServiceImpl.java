package auto.cc.info.service;


import auto.cc.info.dto.carSpecs.EngineCommand;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EngineServiceImpl implements EngineService{
    @Override
    public EngineCommand addNewEngineDetails(EngineCommand engineCommand) {
        return null;
    }

    @Override
    public Page<EngineCommand> listEngines(int page, int size) {
        return null;
    }

    @Override
    public void removeEngineById(Long engineId) {

    }
}
