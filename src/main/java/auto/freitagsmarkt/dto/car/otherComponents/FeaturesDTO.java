package auto.freitagsmarkt.dto.car.otherComponents;

import lombok.Builder;

@Builder
public record FeaturesDTO(
      Long id,
      String comfort,
      String accessories,
      String others
        ){
}

