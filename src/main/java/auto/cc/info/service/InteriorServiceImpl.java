package auto.cc.info.service;

import auto.cc.info.commands.InteriorCommand;
import auto.cc.info.commands.InteriorEquipmentsCommand;
import auto.cc.info.converters.InteriorCommandToInterior;
import auto.cc.info.converters.InEquipmentsCommandToInEquipments;
import auto.cc.info.converters.InteriorToInteriorCommand;
import auto.cc.info.domain.Interior;
import auto.cc.info.domain.InteriorEquipments;
import auto.cc.info.repository.InteriorEquipmentsRepository;
import auto.cc.info.repository.InteriorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Slf4j
@Service
public class InteriorServiceImpl implements InteriorService{
    private final InteriorRepository interiorRepository;
    private final InteriorEquipmentsRepository interiorEquipmentsRepository;
    private final InEquipmentsCommandToInEquipments toInteriorEquipments;
    private final InteriorCommandToInterior commandToInterior;
    private final InteriorToInteriorCommand interiorToInteriorCommand;

    public InteriorServiceImpl(InteriorRepository interiorRepository, InteriorEquipmentsRepository interiorEquipmentsRepository, InEquipmentsCommandToInEquipments toInteriorEquipments, InteriorCommandToInterior commandToInterior, InteriorToInteriorCommand interiorToInteriorCommand) {
        this.interiorRepository = interiorRepository;
        this.interiorEquipmentsRepository = interiorEquipmentsRepository;
        this.toInteriorEquipments = toInteriorEquipments;
        this.commandToInterior = commandToInterior;
        this.interiorToInteriorCommand = interiorToInteriorCommand;
    }


    @Override
    @Transactional
    public InteriorEquipmentsCommand createInteriorEquip(InteriorEquipmentsCommand interiorEquipmentsCommand) {
        InteriorEquipments interiorEquipments= toInteriorEquipments.convert(interiorEquipmentsCommand);
        interiorEquipmentsRepository.save(interiorEquipments);
        return interiorEquipmentsCommand;
    }

    @Override
    @Transactional
    public InteriorCommand createInterior(InteriorCommand interiorCommand) {
        Optional<InteriorEquipments> interiorEquipmentsOptional=
                interiorEquipmentsRepository.findById(interiorCommand.getInteriorEquipments().getId());
        if(!interiorEquipmentsOptional.isPresent()) return null;
        Interior interior= commandToInterior.convert(interiorCommand);
        interiorRepository.save(interior);
        return interiorCommand;
    }

    @Override
    @Transactional
    public InteriorCommand findInteriorById(Long id) {
        Optional<Interior> interior =interiorRepository.findById(id);
        log.error(interior.get().getInteriorEquipments().getId()+"xxx");
        if(!interior.isPresent()) return null;
        return interiorToInteriorCommand.convert(interior.get());
    }
}
