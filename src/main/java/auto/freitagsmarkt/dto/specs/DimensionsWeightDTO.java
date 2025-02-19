package auto.freitagsmarkt.dto.specs;

import lombok.Builder;

@Builder
public record DimensionsWeightDTO(
      Long dimId,
      String exterior,
      String interior,
      String lcvSpecific,
      String weight
        ){
}
