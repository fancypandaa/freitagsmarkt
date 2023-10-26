package auto.cc.info.service;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.converters.AdsCommandToAds;
import auto.cc.info.converters.AdsToAdsCommand;
import auto.cc.info.domain.Ads;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.Seller;
import auto.cc.info.repository.AdsRepository;
import auto.cc.info.repository.CarRepository;
import auto.cc.info.repository.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AdsServiceImpl implements AdsService {
    private final AdsRepository adsRepository;
    private final SellerRepository sellerRepository;
    private final CarRepository carRepository;
    private final AdsCommandToAds adsCommandToAds;
    private final AdsToAdsCommand adsToAdsCommand;


    public AdsServiceImpl(AdsRepository adsRepository, SellerRepository sellerRepository, CarRepository carRepository, AdsCommandToAds adsCommandToAds, AdsToAdsCommand adsToAdsCommand) {
        this.adsRepository = adsRepository;
        this.sellerRepository = sellerRepository;
        this.carRepository = carRepository;
        this.adsCommandToAds = adsCommandToAds;
        this.adsToAdsCommand = adsToAdsCommand;
    }

    @Override
    public Page<AdsCommand> listAllAds(int page, int size){
        Pageable paging = PageRequest.of(page, size);
        List<AdsCommand> adsCommandsList= adsRepository.findAll(paging).stream().map(ad ->{
            AdsCommand adsCommand = adsToAdsCommand.convert(ad);
            return adsCommand;
        }).collect(Collectors.toList());
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), adsCommandsList.size());
        List<AdsCommand> pageContent = adsCommandsList.subList(start, end);
        return new PageImpl<>(pageContent, paging, adsCommandsList.size());
    }


    @Override
    @Transactional
    public AdsCommand createNewAds(AdsCommand adsCommand) {
        Optional<Seller> sellerOptional= sellerRepository.findById(adsCommand.getSellerId());
        Optional<Car> carOptional= carRepository.findById(adsCommand.getCarId());

        if(!sellerOptional.isPresent() || !carOptional.isPresent()){
            log.error("Seller not found for id: ",adsCommand.getSellerId());
            return new AdsCommand();
        }
        else{
        Seller seller= sellerOptional.get();
        Optional<Ads> adsOptional= seller.getAds()
                .stream().filter(ads -> ads.getCar().getId().equals(adsCommand.getCarId())).findFirst();

        if(adsOptional.isPresent()){
            log.info("Current Ad is Already exist");
            return null;
        }
        else {
            Ads ad = adsCommandToAds.convert(adsCommand);
            ad.setSeller(seller);
            seller.addAdsInfo(ad);
            adsRepository.save(ad);
            return adsToAdsCommand.convert(ad);
        }}

    }

    @Override
    public Ads findAdsById(Long ads_id) {
        Ads ads = adsRepository.findById(ads_id).get();
        return ads;
    }

}
