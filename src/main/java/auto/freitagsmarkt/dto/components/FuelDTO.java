package auto.freitagsmarkt.dto.components;


import auto.freitagsmarkt.domain.enums.FuelType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;

@Builder
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
