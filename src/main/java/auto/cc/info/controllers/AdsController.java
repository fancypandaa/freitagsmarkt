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
    @RequestMapping(value = "/{sellerId}",method = RequestMethod.POST,produces = "application/json")
    public AdsCommand createNewAd(@PathVariable Long sellerId,@RequestBody AdsCommand adsCommand){
        Optional<AdsCommand> adsCommandOptional = Optional.ofNullable(adsService.createNewAds(sellerId,adsCommand));
        if(!adsCommandOptional.isPresent()){
            log.error("Your seller id not found !!!");
            return null;
        }
        else {
            return adsCommandOptional.get();
        }
    }
    @RequestMapping(value ="/{sellerId}/{adsId}",method = RequestMethod.PATCH,produces = "application/json")
    public AdsCommand updateAds(@PathVariable Long sellerId,@PathVariable Long adsId,@RequestBody AdsCommand adsCommand){
        AdsCommand adsCommandI = adsService.updateAds(sellerId,adsId,adsCommand);
        return adsCommandI;
    }
    @RequestMapping(value = "/{adsId}",method = RequestMethod.DELETE,produces = "application/json")
    public void deleteAdsById(@PathVariable Long adsId){
            adsService.removeAdsById(Long.valueOf(adsId));
    }
    @QueryMapping("listAds")
    public Page<AdsCommand> listAds(@Argument int page,@Argument int size){
        Page<AdsCommand> adsList = adsService.listAllAds(page,size);
        return adsList;
    }
    @QueryMapping(name = "findAdById")
    public AdsCommand findAdById(@Argument Long id) {
        AdsCommand ads = adsService.findAdsById(id);
        return ads;
    }
}
