package auto.cc.info.dto.car;


import auto.cc.info.dto.car.otherComponents.FeaturesDTO;
import auto.cc.info.dto.car.otherComponents.InteriorDTO;
import auto.cc.info.dto.car.otherComponents.SafetyAndSecurityDTO;
import auto.cc.info.dto.car.specs.DimensionsWeightDTO;
import auto.cc.info.dto.car.specs.EngineDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CarDTO(
     Long id,
     @NotNull(message = "model cannot be null")
     String model,
     @NotNull(message = "city cannot be null")
     String city,
     Integer days,
     Double price,
     Double mileage,
     String generation,
     String saleStatus,
     @JsonInclude(JsonInclude.Include.NON_NULL)
     Long carBrandId,
     @JsonInclude(JsonInclude.Include.NON_NULL)
     Long sellerId,
     EngineDTO engineDto,
     DimensionsWeightDTO dimensionsAndWeight,
     EngineDTO exterior,
     InteriorDTO interior,
     FeaturesDTO features,
     SafetyAndSecurityDTO safetyAndSecurity
        ){}
