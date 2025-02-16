package auto.freitagsmarkt.service.impl;

import auto.freitagsmarkt.domain.Ads;
import auto.freitagsmarkt.dto.AdsDTO;
import auto.freitagsmarkt.mapper.AdsMapper;
import auto.freitagsmarkt.repository.AdsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdsServiceImplTest {
    @Mock
    private AdsRepository adsRepository;
    @Mock
    private AdsMapper adsMapper;
    @InjectMocks
    private AdsServiceImpl adsService;
    private Ads ads;
    private AdsDTO adsDTO;
    @BeforeEach
    void setUp() {
        ads = new Ads();
        adsDTO =AdsDTO.builder().build();
    }

    @Test
    void listAllAds_whenNoAdsExist() {
        when(adsRepository.findAll(any(PageRequest.class))).thenReturn(Page.empty());
        List<AdsDTO> adsDTOList = adsService.listAllAds(0,10);
        assertTrue(adsDTOList.isEmpty());
        verify(adsRepository,times(1)).findAll(any(PageRequest.class));
    }
    @Test
    void listAllAds_whenAdsExist() {
        when(adsRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(ads)));
        when(adsMapper.toAdsListDTO(anyList())).thenReturn(List.of(adsDTO));
        List<AdsDTO> adsDTOs = adsService.listAllAds(0,5);
        assertFalse(adsDTOs.isEmpty());
        verify(adsRepository,times(1)).findAll(any(PageRequest.class));
        verify(adsMapper,times(1)).toAdsListDTO(anyList());
    }
    @Test
    void listAllAds_whenAdsExist_wrongPage() {
        when(adsRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(ads)));
        List<AdsDTO> adsDTOs = adsService.listAllAds(2,5);
        assertTrue(adsDTOs.isEmpty());
        verify(adsRepository,times(1)).findAll(any(PageRequest.class));
    }
    @Test
    void createNewAd_success() {
        when(adsMapper.toAd(any())).thenReturn(ads);
        when(adsRepository.save(any())).thenReturn(ads);
        when(adsMapper.toAdDTO(any())).thenReturn(adsDTO);
        AdsDTO savedAd = adsService.createNewAd(adsDTO);
        assertNotNull(savedAd);
        verify(adsRepository,times(1)).save(any());
        verify(adsMapper,times(1)).toAd(adsDTO);
    }
    @Test
    void createNewAd_failure() {
      Exception exception = assertThrows(RuntimeException.class,()-> adsService.createNewAd(null));
      assertEquals("Ads cannot created!!",exception.getMessage());
    }
    @Test
    void findAdById_success() {
        when(adsRepository.findById(anyLong())).thenReturn(Optional.of(ads));
        when(adsMapper.toAdDTO(any())).thenReturn(adsDTO);
        AdsDTO savedAdsDTO = adsService.findAdById(1L);
        assertNotNull(savedAdsDTO);
        verify(adsRepository,times(1)).findById(1L);
    }
    @Test
    void findAdById_notFound() {
        when(adsRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> adsService.findAdById(anyLong()));
        assertEquals("Ad Not Found",exception.getMessage());
    }
    @Test
    void updateAd_success() {
        when(adsRepository.findById(anyLong())).thenReturn(Optional.of(ads));
        when(adsRepository.save(any())).thenReturn(ads);
        when(adsMapper.toAdDTO(any())).thenReturn(adsDTO);
        AdsDTO savedAd = adsService.updateAd(1L,adsDTO);
        assertNotNull(savedAd);
        verify(adsMapper,times(1)).updateAdsFromAdsDTO(adsDTO,ads);
        verify(adsRepository,times(1)).save(any());
    }
    @Test
    void updateAd_notFound() {
        when(adsRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> adsService.updateAd(anyLong(),adsDTO));
        assertEquals("Ad not found",exception.getMessage());
     }
    @Test
    void removeAdById_Success() {
        when(adsRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(adsRepository).deleteById(anyLong());
        Boolean ans = adsService.removeAdById(anyLong());
        assertTrue(ans);
        verify(adsRepository,times(1)).deleteById(anyLong());
    }
    @Test
    void removeAdById_notFound() {
        when(adsRepository.existsById(anyLong())).thenReturn(false);
        Boolean ans = adsService.removeAdById(anyLong());
        assertFalse(ans);
    }
}