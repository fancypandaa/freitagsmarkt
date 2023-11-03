package auto.cc.info.converters;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.commands.CarCommand;
import auto.cc.info.domain.Ads;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AdsToAdsCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String STATUS = "ACTIVE";
    public static final Integer DAYSOFSALE = 365;
    public static final Date PUBLISHED = new Date();
    AdsToAdsCommand converter;
    CarToCarCommand carToCarCommand;
    @BeforeEach
    void setUp() {
        converter = new AdsToAdsCommand(carToCarCommand);
    }
    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    void convert() {
        Ads ads = new Ads();
        ads.setId(ID_VALUE);
        ads.setStatus(STATUS);
        ads.setDaysOfSale(DAYSOFSALE);
        ads.setPublished(PUBLISHED);
        Car car = new Car();
        car.setId(ID_VALUE);
        ads.setCar(car);
        Seller seller = new Seller();
        seller.setId(ID_VALUE);
        seller.addAds(ads);
        ads.setSeller(seller);
        AdsCommand adsCommand = converter.convert(ads);
        assertNotNull(adsCommand);
        assertNotNull(adsCommand.getCarId());
        assertEquals(ID_VALUE, adsCommand.getId());
        assertEquals(STATUS, adsCommand.getStatus());
        assertEquals(DAYSOFSALE, adsCommand.getDaysOfSale());
        assertEquals(PUBLISHED, adsCommand.getPublished());
        assertEquals(ID_VALUE, adsCommand.getCarId());

    }

}