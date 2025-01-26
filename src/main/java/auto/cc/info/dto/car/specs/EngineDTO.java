package auto.cc.info.dto.carSpecs;


public record EngineDTO(
      Long id ,
      String engineSpecification,
      String engineConfiguration,
      String engineFluids,
      String serviceIntervals,
      BrakesDTO brakes ,
      SuspensionsDTO suspensions ,
      FuelDTO fuel,
      TransmissionDTO transmission
        ){
}
