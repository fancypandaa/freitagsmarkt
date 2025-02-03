package auto.freitagsmarkt.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Date;
@Builder
public record AdsDTO (
     Long id,
     @Min(1)
     @Max(365)
     Integer daysOfSale,
     @NotBlank(message = "companyName cannot be null")
     String Status,
     @DateTimeFormat(pattern = "MM/dd/yyyy")
     Date published,
     @JsonInclude(JsonInclude.Include.NON_NULL)
     Long sellerId,
     @JsonInclude(JsonInclude.Include.NON_NULL)
     Long carId,
     LocalDateTime createdAt,
     LocalDateTime updatedAt
){
}
