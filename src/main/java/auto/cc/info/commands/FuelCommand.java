package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
public class FuelCommand {
    private Long id;
    private String fuel;
    private String tankVolume;
    private String fuelCapPosition;
    private HashMap<String,String>  fuelConsumptionNEDC = new HashMap<>();
    private String co2Combined;
    private String topSpeed;
    private String acceleration;
}
