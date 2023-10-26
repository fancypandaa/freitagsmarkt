package auto.cc.info.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true,nullable = false)
    private String model;
    private String city;
    private String days;
    private String price;
    private String mileage;
    private String generation;

    @ManyToMany
    @JoinTable(name = "car_seller",
            joinColumns = @JoinColumn(name = "car_id"),inverseJoinColumns = @JoinColumn(name = "seller_id"))
    private List<Seller> sellers= new ArrayList<>();

    @ManyToOne
    private CarBrand carBrand;
    @OneToOne(fetch = FetchType.EAGER)
    private Specs specs;
    @OneToOne
    private Ads ads;
}
