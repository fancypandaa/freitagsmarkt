package auto.freitagsmarkt.service.impl.specs;

import auto.freitagsmarkt.dto.specs.ExteriorDTO;
import auto.freitagsmarkt.mapper.specs.ExteriorMapper;
import auto.freitagsmarkt.repository.specs.ExteriorRepository;
import auto.freitagsmarkt.service.specs.ExteriorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExteriorServiceImpl implements ExteriorService {
    private ExteriorMapper exteriorMapper;
    private ExteriorRepository exteriorRepository;

    public ExteriorServiceImpl(ExteriorMapper exteriorMapper, ExteriorRepository exteriorRepository) {
        this.exteriorMapper = exteriorMapper;
        this.exteriorRepository = exteriorRepository;
    }

    @Override
    public ExteriorDTO createExterior(ExteriorDTO exteriorCommand) {
        return Optional.ofNullable(exteriorCommand)
                .map(exteriorMapper::toExterior)
                .map(exteriorRepository::save)
                .map(exteriorMapper::toExteriorDTO)
                .orElseThrow(() -> new RuntimeException("Exterior not created"));
    }

    @Override
    public ExteriorDTO findByExteriorId(Long id) {
        return exteriorRepository.findById(id)
                .map(exteriorMapper::toExteriorDTO)
                .orElseThrow(() -> new RuntimeException("Exterior not found"));
    }
}