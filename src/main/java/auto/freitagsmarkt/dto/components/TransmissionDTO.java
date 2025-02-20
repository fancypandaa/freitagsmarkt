package auto.freitagsmarkt.dto.components;

import lombok.Builder;

@Builder
public record TransmissionDTO  (
     Long id,
     String driveTrain,
     String transmissionName){
}
