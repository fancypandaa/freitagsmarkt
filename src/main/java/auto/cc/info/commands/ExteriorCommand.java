package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
public class ExteriorCommand {
    private Long id;
    private String chassis;
    private String numberOfDoors;
    private String frontDoors;
    private String backDoors;
    private String platform;
    private HashMap<String,String> chassisOptions =new HashMap<>();
    private ExteriorEquipmentCommand exteriorEquipment;
}
