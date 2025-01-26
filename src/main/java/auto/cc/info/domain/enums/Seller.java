package auto.cc.info.domain.enums;

import auto.cc.info.domain.Ads;
import auto.cc.info.domain.Car;
import auto.cc.info.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
@Entity
@Getter
@Setter
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private SellerType type;
    @Column(unique=true,nullable = false)
    private String name;
    private String phone;
    private String sellerWebsite;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "seller")
    private List<Ads> ads = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "seller")
    private List<Car> cars= new ArrayList<>();
    @OneToOne
    private User user;
    public Seller addAds(Ads ads){
        ads.setSeller(this);
        this.ads.add(ads);
        return this;
    }
    public Seller addCars(Car car){
        car.setSeller(this);
        this.cars.add(car);
        return this;
    }
}
