package auto.cc.info.service;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.commands.SellerCommand;
import auto.cc.info.converters.SellerCommandToSeller;
import auto.cc.info.converters.SellerToSellerCommand;
import auto.cc.info.domain.Ads;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.Seller;
import auto.cc.info.domain.user.User;
import auto.cc.info.repository.SellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

class SellerServiceImplTest {
    @Mock
    private  SellerRepository sellerRepository;
    @Mock
    private SellerCommandToSeller sellerCommandToSeller;
    @Mock
    private  SellerToSellerCommand sellerToSellerCommand;
    SellerService sellerService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sellerService = new SellerServiceImpl(sellerRepository,sellerCommandToSeller,sellerToSellerCommand);
    }

    @Test
    @Transactional
    void createNewSellerProfile() {
        SellerCommand sellerCommand = new SellerCommand();
        sellerCommand.setId(3L);
        sellerCommand.setName("LOL");
        Optional<Seller> optionalSeller = Optional.of(new Seller());
        User user = new User();
        user.setId(2L);
        Seller savedSeller = new Seller();
        savedSeller.setName("LOL");
        savedSeller.addAds(new Ads());
        savedSeller.getAds().iterator().next().setId(3L);
        savedSeller.addCars(new Car());
        savedSeller.setUser(user);
        savedSeller.getCars().iterator().next().setId(3L);
        when(sellerRepository.findById(anyLong())).thenReturn(optionalSeller);
        when(sellerRepository.save(any())).thenReturn(savedSeller);
        when(sellerToSellerCommand.convert(savedSeller)).thenReturn(sellerCommand);
        SellerCommand savedCommand= sellerService.createNewSellerProfile(sellerCommand);
        assertEquals(Long.valueOf(3L), savedCommand.getId());
        verify(sellerRepository, times(1)).findByName("LOL");
    }

    @Test
    void listSellers() {
        Seller seller = new Seller();
        seller.setId(1L);
        Seller sellerI = new Seller();
        sellerI.setId(2L);
        List<Seller> sellerList = new ArrayList<>();
        sellerList.add(seller);
        sellerList.add(sellerI);
        when(sellerRepository.findAll()).thenReturn(sellerList);
        verify(sellerRepository, never()).findAll();
    }

    @Test
    void findSellerById() {
        Seller seller = new Seller();
        seller.setId(1L);
        Optional<Seller> sellerOptional = Optional.of(seller);
        when(sellerRepository.findById(anyLong())).thenReturn(sellerOptional);
        SellerCommand sellerCommand = new SellerCommand();
        sellerCommand.setId(1L);
        when(sellerToSellerCommand.convert(seller)).thenReturn(sellerCommand);
        SellerCommand sellerCommand1 = sellerService.findSellerById(anyLong());
        assertNotNull("Null seller returned", String.valueOf(sellerCommand1.getId()));
        verify(sellerRepository, times(1)).findById(anyLong());
        verify(sellerRepository, never()).findAll();

    }

    @Test
    void removeSellerById() {
        Long idToDelete = Long.valueOf(2L);
        sellerService.removeSellerById(idToDelete);
        verify(sellerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void updateSellerById() throws Exception {
        Seller seller = new Seller();
        seller.setId(2L);
        Optional<Seller> sellerOptional = Optional.of(seller);
        when(sellerRepository.findById(anyLong())).thenReturn(sellerOptional);
        SellerCommand sellerCommand = new SellerCommand();
        sellerCommand.setId(2L);
        sellerCommand.setPhone("555-777-888");
        sellerCommand.setName("CAR-CARE");
        when(sellerToSellerCommand.convert(any())).thenReturn(sellerCommand);
        SellerCommand sellerCommand1 = sellerService.findSellerById(2L);
        assertEquals(Long.valueOf(2L), sellerCommand1.getId());
        assertEquals("555-777-888", sellerCommand1.getPhone());
        assertEquals("CAR-CARE", sellerCommand1.getName());
        verify(sellerRepository, times(1)).findById(anyLong());

        sellerCommand.setName("CAR_CARE");
        sellerCommand.setPhone("555-777-889");
        SellerCommand savedSellerCommand = sellerService.updateSeller(2L,sellerCommand);
        assertEquals(sellerCommand.getPhone(), savedSellerCommand.getPhone());
    }
}