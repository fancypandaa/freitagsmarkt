package auto.cc.info.dto.carSpecs;


import jakarta.validation.constraints.NotBlank;

public record BrakesDTO  (
      Long id ,
      String parkingBrake ,
      String manual ,
      @NotBlank(message = "frontBrakes cannot be null")
      String frontBrakes ,
      String cooling,
      @NotBlank(message = "rearBrakes cannot be null")
      String rearBrakes
){
}
