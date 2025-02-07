package auto.freitagsmarkt.service.impl.specs;

import auto.freitagsmarkt.dto.specs.SuspensionsDTO;
import auto.freitagsmarkt.mapper.specs.SuspensionsMapper;
import auto.freitagsmarkt.repository.specs.SuspensionsRepository;
import auto.freitagsmarkt.service.specs.SuspensionsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuspensionsServiceImpl implements SuspensionsService {
    private SuspensionsMapper suspensionsMapper;
    private SuspensionsRepository suspensionsRepository;
    @Override
    public SuspensionsDTO createNewSuspensionsItems(SuspensionsDTO suspensionsDTO)
    {
        return Optional.of(suspensionsDTO)
                .map(suspensionsMapper::toSuspensions)
                .map(suspensionsRepository::save)
                .map(suspensionsMapper::toSuspensionsDTO)
                .orElseThrow(()-> new RuntimeException("suspensions not created!"));
    }
}
