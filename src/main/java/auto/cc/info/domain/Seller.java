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
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "seller")
    private List<Ads> ads = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "sellers")
    private Set<Car> cars;
    public Seller addAds(Ads ads){
        ads.setSeller(this);
        this.ads.add(ads);
        return this;
    }
}
