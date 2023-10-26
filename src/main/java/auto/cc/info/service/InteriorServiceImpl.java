package auto.cc.info.service;

import auto.cc.info.commands.InteriorCommand;
import auto.cc.info.commands.InteriorEquipmentsCommand;
import auto.cc.info.converters.InteriorCommandToInterior;
import auto.cc.info.converters.InteriorEquipmentsCommandToInteriorEquipments;
import auto.cc.info.domain.Interior;
import auto.cc.info.domain.InteriorEquipments;
import auto.cc.info.repository.InteriorEquipmentsRepository;
import auto.cc.info.repository.InteriorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class InteriorServiceImpl implements InteriorService{
    private final InteriorRepository interiorRepository;
    private final InteriorEquipmentsRepository interiorEquipmentsRepository;
    private final InteriorEquipmentsCommandToInteriorEquipments toInteriorEquipments;
    private final InteriorCommandToInterior commandToInterior;

    public InteriorServiceImpl(InteriorRepository interiorRepository, InteriorEquipmentsRepository interiorEquipmentsRepository, InteriorEquipmentsCommandToInteriorEquipments toInteriorEquipments, InteriorCommandToInterior commandToInterior) {
        this.interiorRepository = interiorRepository;
        this.interiorEquipmentsRepository = interiorEquipmentsRepository;
        this.toInteriorEquipments = toInteriorEquipments;
        this.commandToInterior = commandToInterior;
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
        Interior interior= commandToInterior.convert(interiorCommand);
        interiorRepository.save(interior);
        return interiorCommand;
    }
}
