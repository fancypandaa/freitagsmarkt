package auto.freitagsmarkt.domain.car;

import auto.freitagsmarkt.domain.BaseEntity;
import auto.freitagsmarkt.domain.Seller;
import auto.freitagsmarkt.domain.carSpecs.DimensionsWeight;
import auto.freitagsmarkt.domain.carSpecs.Engine;
import auto.freitagsmarkt.domain.components.Exterior;
import auto.freitagsmarkt.domain.components.Features;
import auto.freitagsmarkt.domain.components.Interior;
import auto.freitagsmarkt.domain.components.SafetyAndSecurity;
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
