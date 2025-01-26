package auto.cc.info.dto.carSpecs;


import auto.cc.info.domain.enums.FuelType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public record FuelDTO (
      Long id ,
    @Enumerated(value = EnumType.STRING)
    FuelType fuelType ,
      String tankVolume ,
      String fuelCapPosition ,
      String fuelConsumptionNEDC,
      String co2Combined ,
      String topSpeed ,
      String acceleration
    ){
}
