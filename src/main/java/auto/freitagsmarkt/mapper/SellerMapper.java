package auto.freitagsmarkt.mapper;

import auto.freitagsmarkt.domain.Seller;
import auto.freitagsmarkt.dto.SellerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SellerMapper {
    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);
    SellerDTO toSellerDTO(Seller seller);
    Seller toSeller(SellerDTO sellerDTO);
    List<SellerDTO> toSellerListDTO(List<Seller> sellers);
    void updateSellerFromSellerDTO(SellerDTO sellerDTO, @MappingTarget Seller seller);

}
