package auto.cc.info.commands;

import auto.cc.info.domain.FuelType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
public class FuelCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;
    private String tankVolume;
    private String fuelCapPosition;
    private HashMap<String,String>  fuelConsumptionNEDC = new HashMap<>();
    private String co2Combined;
    private String topSpeed;
    private String acceleration;
}
