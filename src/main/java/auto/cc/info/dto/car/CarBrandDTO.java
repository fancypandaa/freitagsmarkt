package auto.cc.info.dto;
import auto.cc.info.dto.carSpecs.CarDTO;
import java.util.*;

public record CarBrandDTO(
        Long id,
        String name,
        String countryOfOrigin,
        Integer productionYears,
        Integer series,
        String logoUrl,
        List<CarDTO> cars
    ){
}
