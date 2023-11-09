package auto.cc.info.service;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.commands.SellerCommand;
import auto.cc.info.converters.AdsCommandToAds;
import auto.cc.info.converters.AdsToAdsCommand;
import auto.cc.info.domain.Ads;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.Seller;
import auto.cc.info.repository.AdsRepository;
import auto.cc.info.repository.CarRepository;
import auto.cc.info.repository.SellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;



class AdsServiceImplTest {
    @Mock
    private AdsRepository adsRepository;
    @Mock
    private SellerRepository sellerRepository;
    @Mock
    private CarRepository carRepository;
    @Mock
    private AdsCommandToAds adsCommandToAds;
    @Mock
    private AdsToAdsCommand adsToAdsCommand;

    private AdsService adsService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        adsService = new AdsServiceImpl(adsRepository,sellerRepository,carRepository,adsCommandToAds,adsToAdsCommand);
    }

    @Test
    @Transactional
    void listAllAds() {
        Ads ads = new Ads();
        ads.setId(1L);
        Ads adsI = new Ads();
        adsI.setId(2L);
        List<Ads> adsList = new ArrayList<>();
        adsList.add(ads);
        adsList.add(adsI);
        when(adsRepository.findAll()).thenReturn(adsList);
        verify(adsRepository, never()).findAll();
    }
    @Test
    void findAdsById() {
        Ads ads = new Ads();
        ads.setId(1L);
        Optional<Ads> adsOptional = Optional.of(ads);
        when(adsRepository.findById(anyLong())).thenReturn(adsOptional);
        AdsCommand adsCommand = new AdsCommand();
        adsCommand.setId(1L);
        when(adsToAdsCommand.convert(ads)).thenReturn(adsCommand);
        AdsCommand adsCommand1 = adsService.findAdsById(anyLong());
        assertNotNull("Null ads returned", String.valueOf(adsCommand.getId()));
        verify(adsRepository, times(1)).findById(anyLong());
        verify(adsRepository, never()).findAll();
    }
    @Test
    public void removeAdsById() throws Exception {
        Long idToDelete = Long.valueOf(2L);
        adsService.removeAdsById(idToDelete);
        verify(adsRepository, times(1)).deleteById(anyLong());
    }
    @Test
    public void updateAdsById() throws Exception {
        Seller seller = new Seller();
        seller.setId(2L);
        Ads ads = new Ads();
        ads.setId(2L);
        ads.setSeller(seller);
        Optional<Ads> adsOptional = Optional.of(ads);

        when(adsRepository.findById(anyLong())).thenReturn(adsOptional);

        AdsCommand adsCommand = new AdsCommand();
        adsCommand.setId(2L);
        adsCommand.setDaysOfSale(5);
        adsCommand.setStatus("for_sale");
        when(adsToAdsCommand.convert(any())).thenReturn(adsCommand);
        AdsCommand adsCommands = adsService.findAdsById(2L);
        assertEquals(Long.valueOf(2L), adsCommands.getId());
        assertEquals(5, adsCommands.getDaysOfSale());
        assertEquals("for_sale", adsCommands.getStatus());
        verify(adsRepository, times(1)).findById(anyLong());
        adsCommands.setDaysOfSale(6);
        adsCommands.setStatus("sold");
        AdsCommand savedAdsCommand = adsService.updateAds(2L,2L,adsCommands);
        assertEquals(6, adsCommands.getDaysOfSale());
        assertEquals("sold", adsCommands.getStatus());
    }
}