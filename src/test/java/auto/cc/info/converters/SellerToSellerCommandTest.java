package auto.cc.info.converters;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.commands.SellerCommand;
import auto.cc.info.domain.Ads;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.Seller;
import auto.cc.info.domain.SellerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SellerToSellerCommandTest {

    private static final Long ID_VALUE = 1L;
    private static final String TYPE="INDIVIDUAL";
    private static final String PHONE="+58550555";
    private static final String NAME ="LOL";
    private static final String SELLER_WEBSITE="URL";
    SellerToSellerCommand converter;
    CarToCarCommand carToCarCommand;

    @BeforeEach
    void setUp() {
        converter = new SellerToSellerCommand(new AdsToAdsCommand(carToCarCommand),carToCarCommand);
    }
    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Seller()));
    }
    @Test
    void convert() {
        Seller seller= new Seller();
        seller.setId(ID_VALUE);
        seller.setSellerWebsite(SELLER_WEBSITE);
        seller.setType(SellerType.valueOf(TYPE));
        seller.setName(NAME);
        seller.setPhone(PHONE);
        Car car = new Car();
        car.setId(ID_VALUE);
        Ads ads= new Ads();
        ads.setId(ID_VALUE);
        ads.setSeller(seller);
        ads.setCar(car);
        seller.getAds().add(ads);
        SellerCommand sellerCommand= converter.convert(seller);
        assertNotNull(sellerCommand);
        assertNotNull(sellerCommand.getAds());
        assertEquals(ID_VALUE, sellerCommand.getId());
        assertEquals(SELLER_WEBSITE, sellerCommand.getSellerWebsite());
        assertEquals(NAME, sellerCommand.getName());
        assertEquals(PHONE, sellerCommand.getPhone());
        assertEquals(1, sellerCommand.getAds().size());

    }

}