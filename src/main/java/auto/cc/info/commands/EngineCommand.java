package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
@NoArgsConstructor
@Getter
@Setter
public class EngineCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    private HashMap<String,Integer> engineSpecification= new HashMap<>();
    private HashMap<String,String> engineConfiguration= new HashMap<>();
    private HashMap<String,String> engineFluids= new HashMap<>();
    private HashMap<String,String> serviceIntervals= new HashMap<>();
    private BrakesCommand brakes;
    private SuspensionsCommand suspensions;
    private FuelCommand fuel;
    private TransmissionCommand transmission;

}
