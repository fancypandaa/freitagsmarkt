package auto.freitagsmarkt.service.impl.otherComponents;

import auto.freitagsmarkt.dto.components.TransmissionDTO;
import auto.freitagsmarkt.mapper.components.TransmissionMapper;
import auto.freitagsmarkt.repository.components.TransmissionRepository;
import auto.freitagsmarkt.service.otherComponents.TransmissionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransmissionsServiceImpl implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    private TransmissionMapper transmissionMapper;
    @Override
    public TransmissionDTO createNewTransmissionsItems(TransmissionDTO transmissionDTO) {
        return Optional.of(transmissionDTO)
                .map(transmissionMapper::toTransmission)
                .map(transmissionRepository::save)
                .map(transmissionMapper::toTransmissionDTO)
                .orElseThrow(() -> new RuntimeException("Transmissions not created!"));
    }

    @Override
    public TransmissionDTO findTransmissionsById(Long transmissionId) {
        return transmissionRepository.findById(transmissionId)
                .map(transmissionMapper::toTransmissionDTO)
                .orElseThrow(()-> new RuntimeException("Transmissions not found"));
    }
}
