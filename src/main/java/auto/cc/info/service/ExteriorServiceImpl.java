package auto.cc.info.service;

import auto.cc.info.commands.ExteriorCommand;
import auto.cc.info.commands.ExteriorEquipmentCommand;
import auto.cc.info.converters.ExteriorCommandToExterior;
import auto.cc.info.converters.ExEquipmentCommandToExEquipment;
import auto.cc.info.converters.ExteriorToExteriorCommand;
import auto.cc.info.domain.Exterior;
import auto.cc.info.domain.ExteriorEquipment;
import auto.cc.info.repository.ExteriorEquipmentRepository;
import auto.cc.info.repository.ExteriorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class ExteriorServiceImpl implements ExteriorService{
    private final ExteriorEquipmentRepository exteriorEquipmentRepository;
    private final ExteriorRepository exteriorRepository;
    private final ExEquipmentCommandToExEquipment exteriorEquipCommandToExteriorEquip;
    private final ExteriorCommandToExterior exteriorCommandToExterior;
    private final ExteriorToExteriorCommand exteriorToExteriorCommand;

    public ExteriorServiceImpl(ExteriorEquipmentRepository exteriorEquipmentRepository, ExteriorRepository exteriorRepository, ExEquipmentCommandToExEquipment exteriorEquipCommandToExteriorEquip, ExteriorCommandToExterior exteriorCommandToExterior, ExteriorToExteriorCommand exteriorToExteriorCommand) {
        this.exteriorEquipmentRepository = exteriorEquipmentRepository;
        this.exteriorRepository = exteriorRepository;
        this.exteriorEquipCommandToExteriorEquip = exteriorEquipCommandToExteriorEquip;
        this.exteriorCommandToExterior = exteriorCommandToExterior;
        this.exteriorToExteriorCommand = exteriorToExteriorCommand;
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
        Optional<ExteriorEquipment> exteriorEquipmentCommandOptional = exteriorEquipmentRepository.findById(exteriorCommand.getExteriorEquipment().getId());
        if(!exteriorEquipmentCommandOptional.isPresent()){
            return null;
        }
        Exterior exterior= exteriorCommandToExterior.convert(exteriorCommand);
        exteriorRepository.save(exterior);
        return exteriorCommand;
    }

    @Override
    @Transactional
    public ExteriorCommand findByExteriorId(Long id) {
        Optional<Exterior> exterior= exteriorRepository.findById(id);
        if(!exterior.isPresent()) return null;
        return exteriorToExteriorCommand.convert(exterior.get());
    }
}
