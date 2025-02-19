package auto.freitagsmarkt.service.impl.specs;


import auto.freitagsmarkt.domain.specs.Engine;
import auto.freitagsmarkt.dto.specs.EngineDTO;
import auto.freitagsmarkt.mapper.specs.EngineMapper;
import auto.freitagsmarkt.repository.specs.EngineRepository;
import auto.freitagsmarkt.service.specs.EngineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EngineServiceImpl implements EngineService {
    private EngineRepository engineRepository;
    private EngineMapper engineMapper;

    public EngineServiceImpl(EngineRepository engineRepository, EngineMapper engineMapper) {
        this.engineRepository = engineRepository;
        this.engineMapper = engineMapper;
    }

    @Override
    public EngineDTO addNewEngineDetails(EngineDTO engineCommand) {
        return Optional.ofNullable(engineCommand)
                .map(engineMapper::toEngine)
                .map(engineRepository::save)
                .map(engineMapper::toEngineDTO)
                .orElseThrow(() -> new RuntimeException("Engine cannot created"));
    }

    @Override
    public List<EngineDTO> listEngines(int page, int size) {
        Page<Engine> enginePage  = engineRepository.findAll(PageRequest.of(page, size));
        if(enginePage.getTotalElements() <=0){
            return Collections.emptyList();
        }
        return engineMapper.engineListDTO(enginePage.getContent());
    }

    @Override
    public EngineDTO findEngineById(Long engineId) {
        return engineRepository.findById(engineId)
                .map(engineMapper::toEngineDTO)
                .orElseThrow(() -> new RuntimeException("Engine Not Found"));
    }

    @Override
    public Boolean removeEngineById(Long engineId) {
        if(engineRepository.existsById(engineId)){
            engineRepository.deleteById(engineId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
