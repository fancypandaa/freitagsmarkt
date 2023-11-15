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
public class InteriorEquipments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> steeringWheels =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> trunk =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> design =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> seats =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> rimsAndTires =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> otherEquipments =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> tireDimensions =new HashMap<>();
}
