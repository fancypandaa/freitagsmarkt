package auto.cc.info.service;

import auto.cc.info.commands.SuspensionsCommand;
import auto.cc.info.commands.TransmissionCommand;
import auto.cc.info.commands.custom.IFuelCustom;
import auto.cc.info.commands.custom.ITransmissionCustom;

import java.util.List;

public interface TransmissionService {
    TransmissionCommand createNewTransmissionsItems(TransmissionCommand transmissionCommand);
    List<ITransmissionCustom> getTransmissionTypesByGroups();
}
