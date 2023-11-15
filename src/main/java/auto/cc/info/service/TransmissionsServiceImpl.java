package auto.cc.info.service;

import auto.cc.info.commands.TransmissionCommand;
import auto.cc.info.commands.custom.IFuelCustom;
import auto.cc.info.commands.custom.ITransmissionCustom;
import auto.cc.info.converters.TransmissionCommandToTransmission;
import auto.cc.info.converters.TransmissionToTransmissionCommand;
import auto.cc.info.domain.Transmission;
import auto.cc.info.repository.TransmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class TransmissionsServiceImpl implements TransmissionService{
    private final TransmissionRepository transmissionRepository;
    private final TransmissionToTransmissionCommand transmissionToTransmissionCommand;
    private final TransmissionCommandToTransmission transmissionCommandToTransmission;

    public TransmissionsServiceImpl(TransmissionRepository transmissionRepository, TransmissionToTransmissionCommand transmissionToTransmissionCommand, TransmissionCommandToTransmission transmissionCommandToTransmission) {
        this.transmissionRepository = transmissionRepository;
        this.transmissionToTransmissionCommand = transmissionToTransmissionCommand;
        this.transmissionCommandToTransmission = transmissionCommandToTransmission;
    }

    @Override
    public TransmissionCommand createNewTransmissionsItems(TransmissionCommand transmissionCommand) {
        Transmission transmission = transmissionCommandToTransmission.convert(transmissionCommand);
        transmissionRepository.save(transmission);
        return transmissionCommand;
    }

    @Override
    @Transactional
    public List<ITransmissionCustom> getTransmissionTypesByGroups() {
        List<ITransmissionCustom> transmissionCustoms= transmissionRepository.getTransmissionTypesByGroups();
        return transmissionCustoms;
    }
}
