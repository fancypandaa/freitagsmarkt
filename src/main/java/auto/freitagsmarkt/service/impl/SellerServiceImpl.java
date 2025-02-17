package auto.freitagsmarkt.service.impl;

import auto.freitagsmarkt.domain.Seller;
import auto.freitagsmarkt.dto.SellerDTO;
import auto.freitagsmarkt.mapper.SellerMapper;
import auto.freitagsmarkt.repository.SellerRepository;
import auto.freitagsmarkt.service.SellerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    private SellerRepository sellerRepository;
    private SellerMapper sellerMapper;

    public SellerServiceImpl(SellerRepository sellerRepository, SellerMapper sellerMapper) {
        this.sellerRepository = sellerRepository;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public SellerDTO createNewSellerProfile(SellerDTO sellerDTO) {
        return Optional.ofNullable(sellerDTO)
                .map(sellerMapper::toSeller)
                .map(sellerRepository::save)
                .map(sellerMapper::toSellerDTO)
                .orElseThrow(()-> new RuntimeException("Seller cannot created!!"));
    }

    @Override
    public List<SellerDTO> listSellers(int page, int size) {
        Page<Seller> sellers = sellerRepository.findAll(PageRequest.of(page,size));
        if(sellers.getTotalElements() <= 0){
            return Collections.EMPTY_LIST;
        }
        return sellerMapper.toSellerListDTO(sellers.getContent());
    }

    @Override
    public SellerDTO findSellerById(Long sellerId) {
        return sellerRepository.findById(sellerId)
                .map(sellerMapper::toSellerDTO)
                .orElseThrow(() -> new RuntimeException("Seller Not Found"));
    }

    @Override
    public SellerDTO updateSeller(Long sellerId, SellerDTO sellerDTO) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller not found"));
        sellerMapper.updateSellerFromSellerDTO(sellerDTO,seller);
        return sellerMapper.toSellerDTO(sellerRepository.save(seller));
    }

    @Override
    public Boolean removeSellerById(Long sellerId) {
        if(sellerRepository.existsById(sellerId)){
            sellerRepository.deleteById(sellerId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
