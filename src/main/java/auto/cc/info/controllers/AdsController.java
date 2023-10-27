package auto.cc.info.controllers;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.domain.Ads;
import auto.cc.info.service.AdsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/ads")
@Slf4j
public class AdsController {
    private AdsService adsService;
    @Autowired
    public void setAdsService(AdsService adsService){
        this.adsService = adsService;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public AdsCommand createNewAd(@RequestBody AdsCommand adsCommand){
        Optional<AdsCommand> adsCommandOptional = Optional.ofNullable(adsService.createNewAds(adsCommand));
        if(!adsCommandOptional.isPresent()){
            log.error("Your seller id not found !!!");
            return null;
        }
        else {
            return adsCommandOptional.get();
        }
    }

    @QueryMapping("listAds")
    public Page<AdsCommand> listAds(@Argument int page,@Argument int size){
        Page<AdsCommand> adsList = adsService.listAllAds(page,size);
        return adsList;
    }
    @QueryMapping(name = "findAdById")
    public Ads findAdById(@Argument Long id) {
        Ads ads = adsService.findAdsById(id);
        System.out.println(ads.getCar().getId()+" "+ads.getCar().getModel());
        return ads;
    }
}
