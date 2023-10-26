package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
@NoArgsConstructor
@Getter
@Setter
public class InteriorEquipmentsCommand {
    private Long id;
    private HashMap<String,String> steeringWheels =new HashMap<>();
    private HashMap<String,String> trunk =new HashMap<>();
    private HashMap<String,String> design =new HashMap<>();
    private HashMap<String,String> seats =new HashMap<>();
    private HashMap<String,String> rimsAndTires =new HashMap<>();
    private HashMap<String,String> otherEquipments =new HashMap<>();
    private HashMap<String,String> tireDimensions =new HashMap<>();
}
