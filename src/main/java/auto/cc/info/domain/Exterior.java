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
public class Exterior {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chassis;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> chassisOptions =new HashMap<>();
    private String numberOfDoors;
    private String frontDoors;
    private String backDoors;
    private String platform;
    @OneToOne(fetch = FetchType.EAGER)
    ExteriorEquipment exteriorEquipment;
    @OneToOne
    Specs specs;
}
