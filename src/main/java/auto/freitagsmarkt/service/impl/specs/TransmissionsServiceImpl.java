package auto.freitagsmarkt.service.impl.specs;

import auto.freitagsmarkt.dto.specs.TransmissionDTO;
import auto.freitagsmarkt.mapper.specs.TransmissionMapper;
import auto.freitagsmarkt.repository.specs.TransmissionRepository;
import auto.freitagsmarkt.service.specs.TransmissionService;
import org.springframework.stereotype.Service;

import java.util.List;
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
