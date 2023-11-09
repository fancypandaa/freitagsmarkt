package auto.cc.info.converters;

import auto.cc.info.commands.AdsCommand;
import auto.cc.info.commands.CarBrandCommand;
import auto.cc.info.commands.CarCommand;
import auto.cc.info.domain.Ads;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class AdsCommandToAdsTest {
    public static final Long ID_VALUE = 1L;
    public static final String STATUS = "ACTIVE";
    public static final Integer DAYSOFSALE = 365;
    public static final Date PUBLISHED = new Date();
    AdsCommandToAds converter;
    CarCommandToCar carCommandToCar;
    @BeforeEach
    void setUp() {
        converter = new AdsCommandToAds(carCommandToCar);
    }
    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new AdsCommand()));
    }

    @Test
    void convert() {
        AdsCommand adsCommand = new AdsCommand();
        adsCommand.setId(ID_VALUE);
        adsCommand.setStatus(STATUS);
        adsCommand.setDaysOfSale(DAYSOFSALE);
        adsCommand.setPublished(PUBLISHED);
        CarCommand carCommand = new CarCommand();
        carCommand.setId(ID_VALUE);
        adsCommand.setCarId(carCommand.getId());
        Ads ads = converter.convert(adsCommand);
        assertNotNull(ads);
        assertNotNull(ads.getCar());
        assertEquals(ID_VALUE, ads.getId());
        assertEquals(STATUS, ads.getStatus());
        assertEquals(DAYSOFSALE, ads.getDaysOfSale());
        assertEquals(PUBLISHED, ads.getPublished());
        assertEquals(ID_VALUE, ads.getCar().getId());

    }
}