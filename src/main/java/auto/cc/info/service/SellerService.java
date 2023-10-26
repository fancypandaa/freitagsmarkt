package auto.cc.info.service;

import auto.cc.info.commands.SellerCommand;
import org.springframework.data.domain.Page;

public interface SellerService {
    SellerCommand createNewSellerProfile(SellerCommand SellerCommand);
    Page<SellerCommand> listSellers(int page, int size);
}
