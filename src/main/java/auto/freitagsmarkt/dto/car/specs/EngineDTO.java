package auto.freitagsmarkt.dto.car.specs;

import lombok.Builder;

@Builder
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
