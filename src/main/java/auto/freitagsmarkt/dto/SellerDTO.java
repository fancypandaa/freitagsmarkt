package auto.freitagsmarkt.dto;
import auto.freitagsmarkt.domain.enums.SellerType;
import auto.freitagsmarkt.dto.car.CarDTO;
import lombok.Builder;

import java.util.*;


@Builder
public record SellerDTO(
     Long id,
     SellerType type,
     String name,
     String phone,
     String sellerWebsite,
     List<AdsDTO> ads,
     List<CarDTO> cars,
     Long userId
        ){

}
