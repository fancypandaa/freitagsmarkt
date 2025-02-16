package auto.freitagsmarkt.dto.specs;

import lombok.Builder;

@Builder
public record TransmissionDTO  (
     Long id,
     String driveTrain,
     String transmissionName){
}
