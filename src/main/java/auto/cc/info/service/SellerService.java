package auto.cc.info.service;

import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.commands.SellerCommand;
import org.springframework.data.domain.Page;

public interface SellerService {
    SellerCommand createNewSellerProfile(SellerCommand SellerCommand);
    Page<SellerCommand> listSellers(int page, int size);
    SellerCommand findSellerById(Long sellerId);
    SellerCommand updateSeller(Long sellerId, SellerCommand sellerCommand);

    void removeSellerById(Long sellerId);
}
