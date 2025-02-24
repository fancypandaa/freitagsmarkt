package auto.freitagsmarkt.service.impl.otherComponents;


import auto.freitagsmarkt.domain.othersComponents.Brakes;
import auto.freitagsmarkt.dto.components.BrakesDTO;
import auto.freitagsmarkt.mapper.components.BrakesMapper;
import auto.freitagsmarkt.repository.components.BrakesRepository;
import auto.freitagsmarkt.service.otherComponents.BrakesService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrakesServiceImpl implements BrakesService {
    private BrakesRepository brakesRepository;
    private BrakesMapper brakesMapper;

    public BrakesServiceImpl(BrakesRepository brakesRepository, BrakesMapper brakesMapper) {
        this.brakesRepository = brakesRepository;
        this.brakesMapper = brakesMapper;
    }

    @Override
    public BrakesDTO addBrakes(BrakesDTO brakesDTO) {
        return Optional.of(brakesDTO)
                .map(brakesMapper::toBrakes)
                .map(brakesRepository::save)
                .map(brakesMapper::toBrakesDTO)
                .orElseThrow(()-> new RuntimeException("Brakes cannot created!!"));
    }

    @Override
    public BrakesDTO findBrakesById(Long id) {
        return brakesRepository.findById(id)
                .map(brakesMapper::toBrakesDTO)
                .orElseThrow(() -> new RuntimeException("Brakes not found"));
    }

    @Override
    public BrakesDTO updateBrakesById(Long id, BrakesDTO brakesDTO) {
        Brakes brakes = brakesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brakes not found"));
        brakesMapper.updateBrakesFromBrakesDTO(brakesDTO,brakes);
        return brakesMapper.toBrakesDTO(brakesRepository.save(brakes));
    }
}
