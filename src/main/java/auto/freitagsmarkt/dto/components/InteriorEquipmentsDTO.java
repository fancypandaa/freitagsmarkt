package auto.freitagsmarkt.dto.components;

import lombok.Builder;

@Builder
public record InteriorEquipmentsDTO(
      Long id,
       String steeringWheels,
       String trunk,
       String design,
       String seats,
       String rimsTires,
       String otherEquipments ,
       String tireDimensions
        ){}