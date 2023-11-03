package auto.cc.info.service;

import auto.cc.info.commands.EngineCommand;
import auto.cc.info.converters.EngineCommandToEngine;
import auto.cc.info.converters.EngineToEngineCommand;
import auto.cc.info.domain.*;
import auto.cc.info.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EngineServiceImpl implements EngineService{
    private final EngineRepository engineRepository;
    private final EngineCommandToEngine engineCommandToEngine;
    private final EngineToEngineCommand engineToEngineCommand;
    private final BrakesRepository brakesRepository;
    private final FuelRepository fuelRepository;
    private final SuspensionsRepository suspensionsRepository;
    private final TransmissionRepository transmissionRepository;

    public EngineServiceImpl(EngineRepository engineRepository, EngineCommandToEngine engineCommandToEngine, EngineToEngineCommand engineToEngineCommand, BrakesRepository brakesRepository, FuelRepository fuelRepository, SuspensionsRepository suspensionsRepository, TransmissionRepository transmissionRepository) {
        this.engineRepository = engineRepository;
        this.engineCommandToEngine = engineCommandToEngine;
        this.engineToEngineCommand = engineToEngineCommand;
        this.brakesRepository = brakesRepository;
        this.fuelRepository = fuelRepository;
        this.suspensionsRepository = suspensionsRepository;
        this.transmissionRepository = transmissionRepository;
    }

    @Override
    @Transactional
    public EngineCommand addNewEngineDetails(EngineCommand engineCommand) {
        Optional<Brakes> brakesOptional = brakesRepository.findById(engineCommand.getBrakes().getId());
        Optional<Fuel> fuelOptional = fuelRepository.findById(engineCommand.getFuel().getId());
        Optional<Suspensions> suspensionsOptional = suspensionsRepository.findById(engineCommand.getSuspensions().getId());
        Optional<Transmission> transmission = transmissionRepository.findById(engineCommand.getTransmission().getId());

        if(!brakesOptional.isPresent() || !fuelOptional.isPresent()||
         !suspensionsOptional.isPresent() || !transmission.isPresent()){
            return new EngineCommand();
        }
        Engine engine = engineCommandToEngine.convert(engineCommand);
        engineRepository.save(engine);

        return engineCommand;
    }

    @Override
    @Transactional
    public Page<EngineCommand> listEngines(int page,int size) {
        Pageable paging = PageRequest.of(page, size);
        List<EngineCommand> engineCommandList = engineRepository.findAll(paging).stream()
                .map(engine -> {
                    EngineCommand engineCommand = engineToEngineCommand.convert(engine);
                    return engineCommand;
                }).collect(Collectors.toList());
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), engineCommandList.size());
        List<EngineCommand> pageContent = engineCommandList.subList(start,end);
        return new PageImpl<>(pageContent, paging, engineCommandList.size());
    }

    @Override
    public void removeEngineById(Long engineId) {
        engineRepository.deleteById(engineId);
    }
}
