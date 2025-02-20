package auto.freitagsmarkt.service.impl.otherComponents;

import auto.freitagsmarkt.dto.components.SuspensionsDTO;
import auto.freitagsmarkt.mapper.components.SuspensionsMapper;
import auto.freitagsmarkt.repository.components.SuspensionsRepository;
import auto.freitagsmarkt.service.otherComponents.SuspensionsService;
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
