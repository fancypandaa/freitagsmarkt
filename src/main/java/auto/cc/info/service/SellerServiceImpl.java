package auto.cc.info.service;

import auto.cc.info.commands.SellerCommand;
import auto.cc.info.converters.SellerCommandToSeller;
import auto.cc.info.converters.SellerToSellerCommand;
import auto.cc.info.domain.Seller;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.repository.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SellerServiceImpl implements SellerService{
    private final SellerRepository sellerRepository;
    private final SellerCommandToSeller sellerCommandToSeller;
    private final SellerToSellerCommand sellerToSellerCommand;

    public SellerServiceImpl(SellerRepository sellerRepository, SellerCommandToSeller sellerCommandToSeller, SellerToSellerCommand sellerToSellerCommand) {
        this.sellerRepository = sellerRepository;
        this.sellerCommandToSeller = sellerCommandToSeller;
        this.sellerToSellerCommand = sellerToSellerCommand;
    }

    @Override
    @Transactional
    @RolesAllowed({Constants.SELLER})
    public SellerCommand createNewSellerProfile(SellerCommand sellerCommand) {
        Optional<Seller> sellerOptional = Optional.ofNullable(sellerRepository.findByName(sellerCommand.getName()));
        if(sellerOptional.isPresent()) {
            return new SellerCommand();
        }
        Seller seller = sellerCommandToSeller.convert(sellerCommand);
        sellerRepository.save(seller);
        return sellerCommand;
    }

    @Override
    @Transactional
    @RolesAllowed({Constants.SELLER})
    public Page<SellerCommand> listSellers(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        List<SellerCommand> sellerCommandList= sellerRepository.findAll(paging).stream().map(seller ->{
            SellerCommand sellerCommand = sellerToSellerCommand.convert(seller);
            return sellerCommand;
        }).collect(Collectors.toList());
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), sellerCommandList.size());
        List<SellerCommand> pageContent = sellerCommandList.subList(start, end);
        return new PageImpl<>(pageContent, paging, sellerCommandList.size());    }

    @Override
    @Transactional
    @Cacheable(value = "Seller",key="#sellerId")
    @RolesAllowed({Constants.SELLER})
    public SellerCommand findSellerById(Long sellerId) {
        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
        if(!sellerOptional.isPresent()) return null;
        return sellerToSellerCommand.convert(sellerOptional.get());
    }

    @Override
    @RolesAllowed({Constants.SELLER})
    public SellerCommand updateSeller(Long sellerId, SellerCommand sellerCommand) {
        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
        if(!sellerOptional.isPresent()) return null;
        if(sellerOptional.get().getSellerWebsite() != sellerCommand.getSellerWebsite()){
            sellerOptional.get().setSellerWebsite(sellerCommand.getSellerWebsite());
        }
        if(sellerOptional.get().getPhone() != sellerCommand.getPhone()){
            sellerOptional.get().setPhone(sellerCommand.getPhone());
        }
        sellerRepository.save(sellerOptional.get());
        return sellerToSellerCommand.convert(sellerOptional.get());
    }

    @Override
    @RolesAllowed({Constants.SELLER})
    public void removeSellerById(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }
}
