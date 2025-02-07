package auto.freitagsmarkt.service.impl.components;

import auto.freitagsmarkt.dto.components.InteriorEquipmentsDTO;
import auto.freitagsmarkt.mapper.components.InteriorEquipmentsMapper;
import auto.freitagsmarkt.repository.components.InteriorEquipmentsRepository;
import auto.freitagsmarkt.service.components.InteriorEquipmentsService;

import java.util.Optional;

public class InteriorEquipmentsImpl implements InteriorEquipmentsService {
    private InteriorEquipmentsMapper interiorEquipmentsMapper;
    private InteriorEquipmentsRepository interiorEquipmentsRepository;

    public InteriorEquipmentsImpl(
            InteriorEquipmentsMapper interiorEquipmentsMapper,
            InteriorEquipmentsRepository interiorEquipmentsRepository) {
        this.interiorEquipmentsMapper = interiorEquipmentsMapper;
        this.interiorEquipmentsRepository = interiorEquipmentsRepository;
    }

    @Override
    public InteriorEquipmentsDTO createNewInteriorEquipment(InteriorEquipmentsDTO interiorEquipmentsDTO) {
        return Optional.of(interiorEquipmentsDTO)
                .map(interiorEquipmentsMapper::toInteriorEquipments)
                .map(interiorEquipmentsRepository::save)
                .map(interiorEquipmentsMapper::toInteriorEquipmentsDTO)
                .orElseThrow(()-> new RuntimeException("Interior - Equipment not created!!"));
    }

    @Override
    public InteriorEquipmentsDTO findInteriorEquipmentById(Long id) {
        return interiorEquipmentsRepository.findById(id)
                .map(interiorEquipmentsMapper::toInteriorEquipmentsDTO)
                .orElseThrow(()-> new RuntimeException("Interior-Equipment not found"));
    }
}
