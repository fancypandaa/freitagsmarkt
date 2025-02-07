package auto.freitagsmarkt.domain.carSpecs;

import auto.freitagsmarkt.domain.BaseEntity;
import auto.freitagsmarkt.domain.enums.FuelType;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;


@Entity
@Getter
@Setter
public class Fuel extends BaseEntity {
//    General
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;
    @Column(nullable = false)
    private String tankVolume;
    private String fuelCapPosition;
    @Type(JsonBinaryType.class)
    @Column(name = "fuel_consumptionNEDC",columnDefinition = "jsonb")
    private String  fuelConsumptionNEDC;
//     Emission NEDC
    private String co2Combined;
//    performance
    private String topSpeed;
    private String acceleration;
}
