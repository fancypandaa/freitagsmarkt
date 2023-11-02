package auto.cc.info.commands;

import auto.cc.info.domain.ChassisType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
public class ExteriorCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ChassisType chassis;
    private String numberOfDoors;
    private String frontDoors;
    private String backDoors;
    private String platform;
    private HashMap<String,String> chassisOptions =new HashMap<>();
    private ExteriorEquipmentCommand exteriorEquipment;
}
