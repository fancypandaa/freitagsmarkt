package auto.freitagsmarkt.service;

import auto.freitagsmarkt.dto.car.otherComponents.ExteriorEquipmentDTO;
import auto.freitagsmarkt.mapper.otherComponents.ExteriorEquipmentMapper;
import auto.freitagsmarkt.repository.ExteriorEquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExteriorEquipmentServiceImpl implements ExteriorEquipmentService{
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
