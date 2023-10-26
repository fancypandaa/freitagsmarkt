package auto.cc.info.domain;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Getter
@Setter
@TypeDef(
        name = "json", typeClass = JsonType.class
)
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    General
    @Column(nullable = false)
    private String fuel;
    @Column(nullable = false)
    private String tankVolume;
    private String fuelCapPosition;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String>  fuelConsumptionNEDC = new HashMap<>();
//     Emission NEDC
    private String co2Combined;
//    performance
    private String topSpeed;
    private String acceleration;
    @OneToOne
    Engine engine;
}
