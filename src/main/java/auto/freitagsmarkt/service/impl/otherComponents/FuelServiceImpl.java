package auto.freitagsmarkt.service.impl.otherComponents;

import auto.freitagsmarkt.dto.components.FuelDTO;
import auto.freitagsmarkt.mapper.components.FuelMapper;
import auto.freitagsmarkt.repository.components.FuelRepository;
import auto.freitagsmarkt.service.otherComponents.FuelService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuelServiceImpl implements FuelService {

    private FuelMapper fuelMapper;
    private FuelRepository fuelRepository;

    public FuelServiceImpl(FuelMapper fuelMapper, FuelRepository fuelRepository) {
        this.fuelMapper = fuelMapper;
        this.fuelRepository = fuelRepository;
    }

    @Override
    public FuelDTO addFuelInfo(FuelDTO fuelDTO) {
        return Optional.of(fuelDTO)
                .map(fuelMapper::toFuel)
                .map(fuelRepository::save)
                .map(fuelMapper::toFuelDTO)
                .orElseThrow(() -> new RuntimeException("Cannot create new fuel"));
    }

    @Override
    public FuelDTO findFuelById(Long fuelId) {
        return fuelRepository.findById(fuelId)
                .map(fuelMapper::toFuelDTO)
                .orElseThrow(()-> new RuntimeException("fuel not found!!"));
    }
}
