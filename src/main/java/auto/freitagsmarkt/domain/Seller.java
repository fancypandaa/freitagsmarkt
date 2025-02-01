package auto.cc.info.domain;

import auto.cc.info.domain.enums.SellerType;
import auto.cc.info.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends BaseEntity{
    @Enumerated(value = EnumType.STRING)
    private SellerType type;
    @Column(unique=true,nullable = false)
    private String name;
    private String phone;
    private String sellerWebsite;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "seller",orphanRemoval = true)
    private List<Ads> ads = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "seller",orphanRemoval = true)
    private List<Car> cars= new ArrayList<>();
    @OneToOne
    private User user;
    public Seller addAds(Ads ad) {
        if (ad != null && !this.ads.contains(ad)) {
            this.ads.add(ad);
        }
        return this;
    }
    public void addCar(Car car) {
        if (car != null && !this.cars.contains(car)) {
            this.cars.add(car);
        }
    }
}
