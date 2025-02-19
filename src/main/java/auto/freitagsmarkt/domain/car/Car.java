package auto.freitagsmarkt.domain.car;

import auto.freitagsmarkt.domain.BaseEntity;
import auto.freitagsmarkt.domain.Seller;
import auto.freitagsmarkt.domain.specs.DimensionsWeight;
import auto.freitagsmarkt.domain.specs.Engine;
import auto.freitagsmarkt.domain.specs.Exterior;
import auto.freitagsmarkt.domain.specs.Features;
import auto.freitagsmarkt.domain.specs.Interior;
import auto.freitagsmarkt.domain.specs.SafetyAndSecurity;
import auto.freitagsmarkt.domain.enums.SaleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Car extends BaseEntity {

    @Column(unique=true,nullable = false)
    private String model;
    private String city;
    private Integer days;
    private Double price;
    private Double mileage;
    private String generation;
    @Enumerated(value = EnumType.STRING)
    private SaleStatus saleStatus;
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
