package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
public class CarCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    private String model;
    private String city;
    private Integer days;
    private Long price;
    private Long mileage;
    private String generation;
    private String saleStatus;
    private Long carBrandId;
    private Long sellerId;
    private EngineCommand engine;
    private DimensionsAndWeightCommand dimensionsAndWeight;
    private ExteriorCommand exterior;
    private InteriorCommand interior;
    private FeaturesCommand features;
    private SafetyAndSecurityCommand safetyAndSecurity;
}
