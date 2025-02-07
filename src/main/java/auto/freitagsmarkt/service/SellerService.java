package auto.freitagsmarkt.service;

import auto.freitagsmarkt.dto.SellerDTO;
import java.util.List;
public interface SellerService {
    SellerDTO createNewSellerProfile(SellerDTO sellerDTO);
    List<SellerDTO> listSellers(int page, int size);
    SellerDTO findSellerById(Long sellerId);
    SellerDTO updateSeller(Long sellerId, SellerDTO sellerDTO);
    void removeSellerById(Long sellerId);
}
