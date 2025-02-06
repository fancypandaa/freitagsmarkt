package auto.freitagsmarkt.dto.car.specs;

import lombok.Builder;

@Builder
public record DimensionsWeightDTO(
      Long id,
      Float length,
      Float width,
      Float widthWithMirrors,
      Float height,
      Float trackFront,
      Float trackRear,
      Float wheelBase,
      Float overhangFront,
      Float overhangRear,
      Float turningCircle,
      Float groundClearance,
//    Interior mm
      String interior,
//    Weight KG
      String weight
        ){
}
