package auto.freitagsmarkt.dto.car;
import lombok.Builder;

import java.util.*;

@Builder
public record CarBrandDTO(
        Long carBrandId,
        String name,
        String countryOfOrigin,
        Integer productionYears,
        Integer series,
        String logoUrl,
        List<CarDTO> carsDto
    ){
}
