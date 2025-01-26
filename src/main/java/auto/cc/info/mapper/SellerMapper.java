package auto.cc.info.mapper;

import auto.cc.info.domain.enums.Seller;
import auto.cc.info.dto.SellerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SellerMapper {
    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);
    SellerDTO sellerToSellerDTO(Seller seller);
    Seller sellerDTOtoSeller(SellerDTO sellerDTO);
    void updateSellerFromSellerDTO(SellerDTO sellerDTO, @MappingTarget Seller seller);

}
