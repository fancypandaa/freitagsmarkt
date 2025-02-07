package auto.freitagsmarkt.service.impl.components;

import auto.freitagsmarkt.dto.components.ExteriorDTO;
import auto.freitagsmarkt.mapper.components.ExteriorMapper;
import auto.freitagsmarkt.repository.components.ExteriorRepository;
import auto.freitagsmarkt.service.components.ExteriorService;
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
        return Optional.of(exteriorCommand)
                .map(exteriorMapper::toExterior)
                .map(exteriorRepository::save)
                .map(exteriorMapper::toExteriorDTO)
                .orElseThrow(() -> new RuntimeException("Exterior cannot created!"));
    }

    @Override
    public ExteriorDTO findByExteriorId(Long id) {
        return exteriorRepository.findById(id)
                .map(exteriorMapper::toExteriorDTO)
                .orElseThrow(() -> new RuntimeException("current exterior not found"));
    }
}