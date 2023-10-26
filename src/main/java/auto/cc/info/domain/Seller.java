package auto.cc.info.domain;

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
    @ManyToMany(mappedBy = "sellers")
    private List<Car> cars;
    public Seller addAdsInfo(Ads ads){
        ads.setSeller(this);
        this.ads.add(ads);
        return this;
    }
}
