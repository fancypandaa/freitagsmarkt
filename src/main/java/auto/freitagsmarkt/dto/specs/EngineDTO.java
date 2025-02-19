package auto.freitagsmarkt.dto.specs;

import auto.freitagsmarkt.dto.components.BrakesDTO;
import auto.freitagsmarkt.dto.components.FuelDTO;
import auto.freitagsmarkt.dto.components.SuspensionsDTO;
import auto.freitagsmarkt.dto.components.TransmissionDTO;
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
