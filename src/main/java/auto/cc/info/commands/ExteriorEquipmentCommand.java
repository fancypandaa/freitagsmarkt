package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@NoArgsConstructor
@Getter
@Setter
public class ExteriorEquipmentCommand {
    private Long id;
    private Map<String,String> sideMirrors =new HashMap<>();
    private Map<String,String> windscreenWipers =new HashMap<>();
    private Map<String,String> windows =new HashMap<>();
    private Map<String,String> lights =new HashMap<>();
    private Map<String,String> rimsAndTires =new HashMap<>();
    private Map<String,String> otherEquipments =new HashMap<>();
    private Map<String,String> tireDimensions =new HashMap<>();

    private String roofColour;
    private String accent;
    private String doorHandles;
}
