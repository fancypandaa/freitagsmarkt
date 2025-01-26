package auto.cc.info.dto.car.specs;


public record DimensionsAndWeightDTO (
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
