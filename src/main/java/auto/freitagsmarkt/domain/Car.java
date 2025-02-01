package auto.cc.info.domain;

import auto.cc.info.domain.carSpecs.CarBrand;
import auto.cc.info.domain.carSpecs.DimensionsWeight;
import auto.cc.info.domain.carSpecs.Engine;
import auto.cc.info.domain.carSpecs.Exterior;
import auto.cc.info.domain.exCarComponents.Features;
import auto.cc.info.domain.exCarComponents.Interior;
import auto.cc.info.domain.exCarComponents.SafetyAndSecurity;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private Seller seller;
    @ManyToOne(fetch = FetchType.LAZY)
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
