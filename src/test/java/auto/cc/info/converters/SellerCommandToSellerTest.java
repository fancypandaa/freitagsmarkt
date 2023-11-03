package auto.cc.info.converters;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.commands.CarCommand;
import auto.cc.info.commands.SellerCommand;
import auto.cc.info.domain.CarBrand;
import auto.cc.info.domain.Seller;
import auto.cc.info.domain.SellerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SellerCommandToSellerTest {
    private static final Long ID_VALUE = 1L;
    private static final String TYPE="INDIVIDUAL";
    private static final String PHONE="+58550555";
    private static final String NAME ="LOL";
    private static final String SELLER_WEBSITE="URL";
    SellerCommandToSeller converter;
    CarCommandToCar carCommandToCar;

    @BeforeEach
    void setUp() {
        converter = new SellerCommandToSeller(new AdsCommandToAds(carCommandToCar));
    }
    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new SellerCommand()));
    }
    @Test
    void convert() {
        SellerCommand sellerCommand= new SellerCommand();
        sellerCommand.setId(ID_VALUE);
        sellerCommand.setSellerWebsite(SELLER_WEBSITE);
        sellerCommand.setType(SellerType.valueOf(TYPE));
        sellerCommand.setName(NAME);
        sellerCommand.setPhone(PHONE);
        AdsCommand adsCommand= new AdsCommand();
        adsCommand.setId(ID_VALUE);
        sellerCommand.getAds().add(adsCommand);
        Seller seller= converter.convert(sellerCommand);
        assertNotNull(seller);
        assertNotNull(seller.getAds());
        assertEquals(ID_VALUE, seller.getId());
        assertEquals(SELLER_WEBSITE, seller.getSellerWebsite());
        assertEquals(NAME, seller.getName());
        assertEquals(PHONE, seller.getPhone());
        assertEquals(1, seller.getAds().size());

    }
}