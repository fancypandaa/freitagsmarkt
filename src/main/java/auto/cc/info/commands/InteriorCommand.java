package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
public class InteriorCommand {
    private Long id;
    private HashMap<String,String> instrumentCluster  =new HashMap<>();
    private HashMap<String,String> connectivity  =new HashMap<>();
    private HashMap<String,String> climateControl  =new HashMap<>();
    private HashMap<String,String> displays  =new HashMap<>();
    private HashMap<String,String> speakers  =new HashMap<>();
    private HashMap<String,String> rear_viewMirror  =new HashMap<>();
    private HashMap<String,String> interiorStorage  =new HashMap<>();
    private HashMap<String,String> lights  =new HashMap<>();
    private InteriorEquipmentsCommand interiorEquipments;
}
