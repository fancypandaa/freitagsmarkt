package auto.cc.info.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
@Entity
@Getter
@Setter
public class InteriorEquipments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private HashMap<String,String> steeringWheels =new HashMap<>();
    private HashMap<String,String> trunk =new HashMap<>();
    private HashMap<String,String> design =new HashMap<>();
    private HashMap<String,String> seats =new HashMap<>();
    private HashMap<String,String> rimsAndTires =new HashMap<>();
    private HashMap<String,String> otherEquipments =new HashMap<>();
    private HashMap<String,String> tireDimensions =new HashMap<>();
    @OneToOne
    Interior interior;
}
