package auto.freitagsmarkt.dto.components;

import lombok.Builder;

@Builder
public record FeaturesDTO(
      Long id,
      String comfort,
      String accessories,
      String others
        ){
}

