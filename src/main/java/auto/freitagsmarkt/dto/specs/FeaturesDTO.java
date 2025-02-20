package auto.freitagsmarkt.dto.specs;

import lombok.Builder;

@Builder
public record FeaturesDTO(
      Long featuresId,
      String comfort,
      String accessories,
      String others
        ){
}

