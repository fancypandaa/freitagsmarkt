package auto.cc.info.dto;
import auto.cc.info.domain.enums.SellerType;
import auto.cc.info.dto.car.CarDTO;
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
