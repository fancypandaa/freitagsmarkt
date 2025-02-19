package auto.freitagsmarkt.dto.specs;

import lombok.Builder;

@Builder
public record EngineDTO(
      Long engineId,
      String engineSpecification,
      String engineConfiguration,
      String engineFluids,
      String serviceIntervals,
      String performance,
      BrakesDTO brakes,
      SuspensionsDTO suspensions,
      FuelDTO fuel,
      TransmissionDTO transmission
){
}
