package auto.cc.info.mapper.specs;

import auto.cc.info.domain.Transmission;
import auto.cc.info.dto.car.specs.TransmissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransmissionMapper {
    TransmissionMapper INSTANCE = Mappers.getMapper(TransmissionMapper.class);
    Transmission transmissionDTOtoTransmission(TransmissionDTO transmissionDTO);
    TransmissionDTO transmissionToTransmissionDTO(Transmission transmission);
}
