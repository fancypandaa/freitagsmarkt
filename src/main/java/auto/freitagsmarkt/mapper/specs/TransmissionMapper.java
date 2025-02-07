package auto.freitagsmarkt.mapper.specs;

import auto.freitagsmarkt.domain.carSpecs.Transmission;
import auto.freitagsmarkt.dto.specs.TransmissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransmissionMapper {
    TransmissionMapper INSTANCE = Mappers.getMapper(TransmissionMapper.class);
    Transmission toTransmission(TransmissionDTO transmissionDTO);
    TransmissionDTO toTransmissionDTO(Transmission transmission);
}
