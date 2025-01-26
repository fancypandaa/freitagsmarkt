package auto.cc.info.domain;

import auto.cc.info.domain.enums.Seller;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Car extends BaseEntity{

    @Column(unique=true,nullable = false)
    private String model;
    private String city;
    private Integer days;
    private Double price;
    private Double mileage;
    private String generation;
    private String saleStatus;
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private CarBrand carBrand;
    @OneToOne(cascade= CascadeType.ALL)
    private Engine engine;
    @OneToOne(cascade=CascadeType.ALL)
    private DimensionsWeight dimensionsWeight;
    @OneToOne(cascade=CascadeType.ALL)
    private Exterior exterior;
    @OneToOne(cascade=CascadeType.ALL)
    private Interior interior;
    @OneToOne(cascade=CascadeType.ALL)
    private Features features;
    @OneToOne(cascade=CascadeType.ALL)
    private SafetyAndSecurity safetyAndSecurity;

}
