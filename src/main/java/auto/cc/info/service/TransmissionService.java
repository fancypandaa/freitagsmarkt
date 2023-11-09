package auto.cc.info.service;

import auto.cc.info.commands.SuspensionsCommand;
import auto.cc.info.commands.TransmissionCommand;

public interface TransmissionService {
    TransmissionCommand createNewTransmissionsItems(TransmissionCommand transmissionCommand);
}
