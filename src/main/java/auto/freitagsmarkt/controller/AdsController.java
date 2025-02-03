package auto.freitagsmarkt.controller;

import auto.freitagsmarkt.dto.AdsDTO;
import auto.freitagsmarkt.service.AdsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/all-ads")
    public ResponseEntity<List<AdsDTO>> listAds(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(adsService.listAllAds(page, size));
    }
    @GetMapping("/{adId}")
    public ResponseEntity<AdsDTO> findAdById(@PathVariable Long adId) {
        return ResponseEntity.ok(adsService.findAdById(adId));
    }

    @PostMapping
    public ResponseEntity<AdsDTO> createNewAd(@RequestBody AdsDTO adsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(adsService.createNewAd(adsDTO));
    }
    @PutMapping("/{adId}")
    public ResponseEntity<AdsDTO> updateAds(@PathVariable Long adId, @RequestBody AdsDTO adsDTO){
        return ResponseEntity.ok(adsService.updateAd(adId,adsDTO));
    }
    @DeleteMapping("{adId}")
    public void deleteAdsById(@PathVariable Long adId){
            adsService.removeAdById(adId);
    }

}
