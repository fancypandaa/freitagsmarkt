package auto.freitagsmarkt.dto.car;


import auto.freitagsmarkt.domain.enums.SaleStatus;
import auto.freitagsmarkt.dto.components.FeaturesDTO;
import auto.freitagsmarkt.dto.components.InteriorDTO;
import auto.freitagsmarkt.dto.components.SafetyAndSecurityDTO;
import auto.freitagsmarkt.dto.specs.DimensionsWeightDTO;
import auto.freitagsmarkt.dto.specs.EngineDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CarDTO(
        Long carId,
        @NotNull(message = "model cannot be null")
     String model,
        @NotNull(message = "city cannot be null")
     String city,
        Integer days,
        Double price,
        Double mileage,
        String generation,
        @Enumerated(value = EnumType.STRING)
         SaleStatus saleStatus,
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
