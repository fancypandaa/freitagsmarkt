package auto.cc.info.dto.car.specs;

import lombok.Builder;

@Builder
public record TransmissionDTO  (
     Long id,
     String driveTrain,
     String transmission){
}
