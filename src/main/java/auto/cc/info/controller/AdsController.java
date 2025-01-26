package auto.cc.info.controllers;

import auto.cc.info.dto.AdsDTO;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.AdsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.*;
@RestController
@RequestMapping("/api/ads")
@Slf4j
public class AdsController {
    private AdsService adsService;
    @Autowired
    public void setAdsService(AdsService adsService){
        this.adsService = adsService;
    }
    @RequestMapping(value = "/{sellerId}",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public AdsDTO createNewAd(@PathVariable Long sellerId, @RequestBody AdsDTO adsCommand){
        Optional<AdsDTO> adsCommandOptional = Optional.ofNullable(adsService.createNewAds(sellerId,adsCommand));
        if(!adsCommandOptional.isPresent()){
            log.error("Your seller id not found !!!");
            return null;
        }
        else {
            return adsCommandOptional.get();
        }
    }
    @RequestMapping(value ="/{sellerId}/{adsId}",method = RequestMethod.PATCH,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public AdsDTO updateAds(@PathVariable Long sellerId, @PathVariable Long adsId, @RequestBody AdsDTO adsCommand){
        AdsDTO adsCommandI = adsService.updateAds(sellerId,adsId,adsCommand);
        return adsCommandI;
    }
    @RequestMapping(value = "/{adsId}",method = RequestMethod.DELETE,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public void deleteAdsById(@PathVariable Long adsId){
            adsService.removeAdsById(Long.valueOf(adsId));
    }
    @QueryMapping("listAds")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public Page<AdsDTO> listAds(@Argument int page, @Argument int size){
        Page<AdsDTO> adsList = adsService.listAllAds(page,size);
        return adsList;
    }
    @QueryMapping(name = "findAdById")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public AdsDTO findAdById(@Argument Long id) {
        AdsDTO ads = adsService.findAdsById(id);
        return ads;
    }
}
