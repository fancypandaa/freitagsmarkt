package auto.freitagsmarkt.service.impl;


import auto.freitagsmarkt.domain.Seller;
import auto.freitagsmarkt.dto.SellerDTO;
import auto.freitagsmarkt.mapper.SellerMapper;
import auto.freitagsmarkt.repository.SellerRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class SellerServiceImplTest {
    @Mock
    private SellerRepository sellerRepository;
    @Mock
    private SellerMapper sellerMapper;
    @InjectMocks
    private SellerServiceImpl sellerService;
    private Seller seller;
    private SellerDTO sellerDTO;

    @BeforeEach
    void setUp() {
        seller = new Seller();
        sellerDTO = SellerDTO.builder().build();
    }
    @Test
    void listSellers_whenNoSellerExist() {
        when(sellerRepository.findAll(any(PageRequest.class))).thenReturn(Page.empty());
        List<SellerDTO> sellerDTOList = sellerService.listSellers(0,10);
        assertTrue(sellerDTOList.isEmpty());
        verify(sellerRepository,times(1)).findAll(any(PageRequest.class));
    }
    @Test
    void listSellers_whenSellerExist() {
        when(sellerRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(seller)));
        when(sellerMapper.toSellerListDTO(anyList())).thenReturn(List.of(sellerDTO));
        List<SellerDTO> sellerDTOs = sellerService.listSellers(0,5);
        assertFalse(sellerDTOs.isEmpty());
        verify(sellerRepository,times(1)).findAll(any(PageRequest.class));
        verify(sellerMapper,times(1)).toSellerListDTO(anyList());
    }
    @Test
    void listAllSeller_whenSellerExist_wrongPage() {
        when(sellerRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(seller)));
        List<SellerDTO> sellerDTOs = sellerService.listSellers(2,5);
        assertTrue(sellerDTOs.isEmpty());
        verify(sellerRepository,times(1)).findAll(any(PageRequest.class));
    }
    @Test
    void createNewSellerProfile_success() {
        when(sellerMapper.toSeller(any())).thenReturn(seller);
        when(sellerRepository.save(any())).thenReturn(seller);
        when(sellerMapper.toSellerDTO(any())).thenReturn(sellerDTO);
        SellerDTO savedSeller = sellerService.createNewSellerProfile(sellerDTO);
        assertNotNull(savedSeller);
        verify(sellerRepository,times(1)).save(any());
        verify(sellerMapper,times(1)).toSeller(sellerDTO);
    }
    @Test
    void createNewSeller_failure() {
        Exception exception = assertThrows(RuntimeException.class,()-> sellerService.createNewSellerProfile(null));
        assertEquals("Seller cannot created!!",exception.getMessage());
    }
    @Test
    void findSellerById_success() {
        when(sellerRepository.findById(anyLong())).thenReturn(Optional.of(seller));
        when(sellerMapper.toSellerDTO(any())).thenReturn(sellerDTO);
        SellerDTO savedSellersDTO = sellerService.findSellerById(1L);
        assertNotNull(savedSellersDTO);
        verify(sellerRepository,times(1)).findById(1L);
    }
    @Test
    void findSellerById_notFound() {
        when(sellerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> sellerService.findSellerById(anyLong()));
        assertEquals("Seller Not Found",exception.getMessage());
    }

    @Test
    void updateAd_success() {
        when(sellerRepository.findById(anyLong())).thenReturn(Optional.of(seller));
        when(sellerRepository.save(any())).thenReturn(seller);
        when(sellerMapper.toSellerDTO(any())).thenReturn(sellerDTO);
        SellerDTO savedAd = sellerService.updateSeller(1L,sellerDTO);
        assertNotNull(savedAd);
        verify(sellerMapper,times(1)).updateSellerFromSellerDTO(sellerDTO,seller);
        verify(sellerRepository,times(1)).save(any());
    }
    @Test
    void updateAd_notFound() {
        when(sellerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class,()-> sellerService.updateSeller(anyLong(),sellerDTO));
        assertEquals("Seller not found",exception.getMessage());
    }
    @Test
    void removeAdById_Success() {
        when(sellerRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(sellerRepository).deleteById(anyLong());
        Boolean ans = sellerService.removeSellerById(anyLong());
        assertTrue(ans);
        verify(sellerRepository,times(1)).deleteById(anyLong());
    }
    @Test
    void removeAdById_notFound() {
        when(sellerRepository.existsById(anyLong())).thenReturn(false);
        Boolean ans = sellerService.removeSellerById(anyLong());
        assertFalse(ans);
    }
}