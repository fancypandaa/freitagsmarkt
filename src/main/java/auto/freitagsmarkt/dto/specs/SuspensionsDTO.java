package auto.freitagsmarkt.dto.specs;

import lombok.Builder;

@Builder
public record SuspensionsDTO(
      Long id ,
      String springFront ,
      String springRear ,
      String anti_rollBar ,
      String suspensionRear,
      String suspensionFront
        ){}
