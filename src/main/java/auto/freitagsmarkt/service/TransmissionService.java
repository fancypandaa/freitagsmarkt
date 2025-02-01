package auto.cc.info.service;

import auto.cc.info.dto.carSpecs.TransmissionCommand;
import auto.cc.info.dto.custom.ITransmissionCustom;

import java.util.List;

public interface TransmissionService {
    TransmissionCommand createNewTransmissionsItems(TransmissionCommand transmissionCommand);
    List<ITransmissionCustom> getTransmissionTypesByGroups();
}
