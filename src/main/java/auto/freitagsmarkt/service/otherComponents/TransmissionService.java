package auto.freitagsmarkt.service.otherComponents;

import auto.freitagsmarkt.dto.components.TransmissionDTO;

public interface TransmissionService {
    TransmissionDTO createNewTransmissionsItems(TransmissionDTO transmissionDTO);
    TransmissionDTO findTransmissionsById(Long transmissionId);

}
