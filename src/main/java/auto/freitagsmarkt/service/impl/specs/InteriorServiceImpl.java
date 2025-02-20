package auto.freitagsmarkt.service.impl.specs;

import auto.freitagsmarkt.dto.specs.InteriorDTO;
import auto.freitagsmarkt.mapper.specs.InteriorMapper;
import auto.freitagsmarkt.repository.specs.InteriorRepository;
import auto.freitagsmarkt.service.specs.InteriorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InteriorServiceImpl implements InteriorService {
    private InteriorMapper interiorMapper;
    private InteriorRepository interiorRepository;

    public InteriorServiceImpl(InteriorMapper interiorMapper, InteriorRepository interiorRepository) {
        this.interiorMapper = interiorMapper;
        this.interiorRepository = interiorRepository;
    }

    @Override
    public InteriorDTO createInterior(InteriorDTO interiorDTO) {
        return Optional.ofNullable(interiorDTO)
                .map(interiorMapper::toInterior)
                .map(interiorRepository::save)
                .map(interiorMapper::toInteriorDTO)
                .orElseThrow(()-> new RuntimeException("Interior not created!"));
    }

    @Override
    public InteriorDTO findInteriorById(Long id) {
        return interiorRepository.findById(id)
                .map(interiorMapper::toInteriorDTO)
                .orElseThrow(()-> new RuntimeException("Interior Not found"));
    }
}
