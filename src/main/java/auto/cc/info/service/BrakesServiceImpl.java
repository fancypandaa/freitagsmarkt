package auto.cc.info.service;

import auto.cc.info.commands.BrakesCommand;
import auto.cc.info.converters.BrakesCommandToBrakes;
import auto.cc.info.converters.BrakesToBrakesCommand;
import auto.cc.info.domain.Brakes;
import auto.cc.info.repository.BrakesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class BrakesServiceImpl implements BrakesService{
    private final BrakesRepository brakesRepository;
    private final BrakesCommandToBrakes brakesCommandToBrakes;
    private final BrakesToBrakesCommand brakesToBrakesCommand;
    public BrakesServiceImpl(BrakesRepository brakesRepository, BrakesCommandToBrakes brakesCommandToBrakes, BrakesToBrakesCommand brakesToBrakesCommand) {
        this.brakesRepository = brakesRepository;
        this.brakesCommandToBrakes = brakesCommandToBrakes;
        this.brakesToBrakesCommand = brakesToBrakesCommand;
    }

    @Override
    @Transactional
    public BrakesCommand addBrakes(BrakesCommand brakesCommand) {
        if(brakesCommand.getFrontBrakes() == null && brakesCommand.getParkingBrake() == null){
            return new BrakesCommand();
        }
        Brakes brakes= brakesCommandToBrakes.convert(brakesCommand);
        brakesRepository.save(brakes);
        return brakesCommand;
    }

    @Override
    public BrakesCommand findBrakesById(Long id) {
        Optional<Brakes> brakes = brakesRepository.findById(id);
        if(!brakes.isPresent()){
            return null;
        }
        return brakesToBrakesCommand.convert(brakes.get());
    }

}
