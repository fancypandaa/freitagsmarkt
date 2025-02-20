package auto.freitagsmarkt.mapper.components;

import auto.freitagsmarkt.domain.othersComponents.Transmission;
import auto.freitagsmarkt.dto.components.TransmissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransmissionMapper {
    TransmissionMapper INSTANCE = Mappers.getMapper(TransmissionMapper.class);
    Transmission toTransmission(TransmissionDTO transmissionDTO);
    TransmissionDTO toTransmissionDTO(Transmission transmission);
}
