package auto.freitagsmarkt.service.impl.components;

import auto.freitagsmarkt.dto.components.ExteriorEquipmentDTO;
import auto.freitagsmarkt.mapper.components.ExteriorEquipmentMapper;
import auto.freitagsmarkt.repository.components.ExteriorEquipmentRepository;
import auto.freitagsmarkt.service.components.ExteriorEquipmentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExteriorEquipmentServiceImpl implements ExteriorEquipmentService {
    private ExteriorEquipmentMapper exteriorEquipmentMapper;
    private ExteriorEquipmentRepository exteriorEquipmentRepository;

    public ExteriorEquipmentServiceImpl(
            ExteriorEquipmentMapper exteriorEquipmentMapper,
            ExteriorEquipmentRepository exteriorEquipmentRepository) {
        this.exteriorEquipmentMapper = exteriorEquipmentMapper;
        this.exteriorEquipmentRepository = exteriorEquipmentRepository;
    }

    @Override
    public ExteriorEquipmentDTO findExteriorEquipmentById(Long exId) {
        return exteriorEquipmentRepository.findById(exId)
                .map(exteriorEquipmentMapper::toExteriorEquipmentDTO)
                .orElseThrow(()-> new RuntimeException("Exterior Equipment not found"));
    }

    @Override
    public ExteriorEquipmentDTO createExteriorEquipment(ExteriorEquipmentDTO exteriorEquipmentDTO) {
        return Optional.of(exteriorEquipmentDTO)
                .map(exteriorEquipmentMapper::toExteriorEquipment)
                .map(exteriorEquipmentRepository::save)
                .map(exteriorEquipmentMapper::toExteriorEquipmentDTO)
                .orElseThrow(() -> new RuntimeException("exterior equipment cannot created!"));
    }
}
