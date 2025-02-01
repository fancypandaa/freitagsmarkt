package auto.cc.info.controller;

import auto.cc.info.dto.AdsDTO;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.AdsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping(AdsController.ADS_URI)
public class AdsController {
    public static final String ADS_URI = "/api/ads";
    private final static Logger log = LoggerFactory.getLogger(AdsController.class);
    private AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @RequestMapping(value = "/{sellerId}",method = RequestMethod.POST,produces = "application/json")
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
    public AdsDTO updateAds(@PathVariable Long sellerId, @PathVariable Long adsId, @RequestBody AdsDTO adsCommand){
        AdsDTO adsCommandI = adsService.updateAds(sellerId,adsId,adsCommand);
        return adsCommandI;
    }
    @RequestMapping(value = "/{adsId}",method = RequestMethod.DELETE,produces = "application/json")
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
    public AdsDTO findAdById(@Argument Long id) {
        AdsDTO ads = adsService.findAdsById(id);
        return ads;
    }
}
