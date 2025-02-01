package auto.cc.info.service;

import auto.cc.info.dto.carSpecs.TransmissionCommand;
import auto.cc.info.dto.custom.ITransmissionCustom;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransmissionsServiceImpl implements TransmissionService{
    @Override
    public TransmissionCommand createNewTransmissionsItems(TransmissionCommand transmissionCommand) {
        return null;
    }

    @Override
    public List<ITransmissionCustom> getTransmissionTypesByGroups() {
        return null;
    }
}
