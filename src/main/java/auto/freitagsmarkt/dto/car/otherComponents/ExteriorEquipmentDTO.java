package auto.freitagsmarkt.dto.car.otherComponents;

import lombok.Builder;

@Builder
public record ExteriorEquipmentDTO(
      Long id,
       String sideMirrors  ,
       String windscreenWipers  ,
       String windows  ,
       String lights  ,
       String rimsAndTires  ,
       String otherEquipments  ,
       String tireDimensions  ,
      String roofColour,
      String accent,
      String doorHandles
        ){
}
