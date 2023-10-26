package auto.cc.info.service;

import auto.cc.info.commands.ExteriorCommand;
import auto.cc.info.commands.ExteriorEquipmentCommand;
import auto.cc.info.converters.ExteriorCommandToExterior;
import auto.cc.info.converters.ExteriorEquipmentCommandToExteriorEquipment;
import auto.cc.info.domain.Exterior;
import auto.cc.info.domain.ExteriorEquipment;
import auto.cc.info.repository.ExteriorEquipmentRepository;
import auto.cc.info.repository.ExteriorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ExteriorServiceImpl implements ExteriorService{
    private final ExteriorEquipmentRepository exteriorEquipmentRepository;
    private final ExteriorRepository exteriorRepository;
    private final ExteriorEquipmentCommandToExteriorEquipment exteriorEquipCommandToExteriorEquip;
    private final ExteriorCommandToExterior exteriorCommandToExterior;

    public ExteriorServiceImpl(ExteriorEquipmentRepository exteriorEquipmentRepository, ExteriorRepository exteriorRepository, ExteriorEquipmentCommandToExteriorEquipment exteriorEquipCommandToExteriorEquip, ExteriorCommandToExterior exteriorCommandToExterior) {
        this.exteriorEquipmentRepository = exteriorEquipmentRepository;
        this.exteriorRepository = exteriorRepository;
        this.exteriorEquipCommandToExteriorEquip = exteriorEquipCommandToExteriorEquip;
        this.exteriorCommandToExterior = exteriorCommandToExterior;
    }

    @Override
    @Transactional

    public ExteriorEquipmentCommand createExteriorEquip(ExteriorEquipmentCommand exteriorEquipmentCommand) {
        ExteriorEquipment exteriorEquipment= exteriorEquipCommandToExteriorEquip.convert(exteriorEquipmentCommand);
        exteriorEquipmentRepository.save(exteriorEquipment);
        return exteriorEquipmentCommand;
    }

    @Override
    @Transactional

    public ExteriorCommand createExterior(ExteriorCommand exteriorCommand) {
        Exterior exterior= exteriorCommandToExterior.convert(exteriorCommand);
        exteriorRepository.save(exterior);
        return exteriorCommand;
    }
}
