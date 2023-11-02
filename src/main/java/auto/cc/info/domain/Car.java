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
    private Long price;
    private Long mileage;
    private String generation;
    private String saleStatus;
//    @ManyToMany
//    @JoinTable(name = "car_seller",
//            joinColumns = @JoinColumn(name = "car_id"),inverseJoinColumns = @JoinColumn(name = "seller_id"))
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private CarBrand carBrand;
    @OneToOne
    private Engine engine;
    @OneToOne
    private DimensionsAndWeight dimensionsAndWeight;
    @OneToOne
    private Exterior exterior;
    @OneToOne
    private Interior interior;
    @OneToOne
    private Features features;
    @OneToOne
    private SafetyAndSecurity safetyAndSecurity;
}
