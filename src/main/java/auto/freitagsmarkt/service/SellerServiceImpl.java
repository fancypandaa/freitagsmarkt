package auto.cc.info.service;

import auto.cc.info.dto.SellerCommand;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService{
    @Override
    public SellerCommand createNewSellerProfile(SellerCommand SellerCommand) {
        return null;
    }

    @Override
    public Page<SellerCommand> listSellers(int page, int size) {
        return null;
    }

    @Override
    public SellerCommand findSellerById(Long sellerId) {
        return null;
    }

    @Override
    public SellerCommand updateSeller(Long sellerId, SellerCommand sellerCommand) {
        return null;
    }

    @Override
    public void removeSellerById(Long sellerId) {

    }
}
