package auto.cc.info.domain;

import auto.cc.info.domain.enums.FuelType;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Getter
@Setter
@TypeDef(
        name = "jsonb", typeClass = JsonBinaryType.class
)
public class Fuel extends BaseEntity{
//    General
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;
    @Column(nullable = false)
    private String tankVolume;
    private String fuelCapPosition;
    @Type(type = "jsonb")
    @Column(name = "fuel_consumptionNEDC",columnDefinition = "jsonb")
    private String  fuelConsumptionNEDC;
//     Emission NEDC
    private String co2Combined;
//    performance
    private String topSpeed;
    private String acceleration;

}
