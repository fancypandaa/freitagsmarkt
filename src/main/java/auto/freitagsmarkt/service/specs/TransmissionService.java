package auto.freitagsmarkt.service.specs;

import auto.freitagsmarkt.dto.specs.TransmissionDTO;

public interface TransmissionService {
    TransmissionDTO createNewTransmissionsItems(TransmissionDTO transmissionDTO);
    TransmissionDTO findTransmissionsById(Long transmissionId);

}
