package auto.cc.info.service;

import auto.cc.info.commands.FuelCommand;
import auto.cc.info.commands.SuspensionsCommand;
import auto.cc.info.converters.FuelCommandToFuel;
import auto.cc.info.converters.FuelToFuelCommand;
import auto.cc.info.converters.SuspensionsCommandToSuspensions;
import auto.cc.info.converters.SuspensionsToSuspensionsCommand;
import auto.cc.info.domain.Fuel;
import auto.cc.info.domain.Suspensions;
import auto.cc.info.repository.FuelRepository;
import auto.cc.info.repository.SuspensionsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class SuspensionsServiceImpl implements SuspensionsService{
    private final SuspensionsCommandToSuspensions toSuspensions;
    private final SuspensionsToSuspensionsCommand suspensionsToSuspensionsCommand;
    private final SuspensionsRepository suspensionsRepository;

    public SuspensionsServiceImpl(SuspensionsCommandToSuspensions toSuspensions, SuspensionsToSuspensionsCommand suspensionsToSuspensionsCommand, SuspensionsRepository suspensionsRepository) {
        this.toSuspensions = toSuspensions;
        this.suspensionsToSuspensionsCommand = suspensionsToSuspensionsCommand;
        this.suspensionsRepository = suspensionsRepository;
    }

    @Override
    public SuspensionsCommand createNewSuspensionsItems(SuspensionsCommand suspensionsCommand) {
        Suspensions suspensions= toSuspensions.convert(suspensionsCommand);
        suspensionsRepository.save(suspensions);
        return suspensionsCommand;
    }
}
