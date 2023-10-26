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
public class Interior {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> instrumentCluster  =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> connectivity  =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> climateControl  =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> displays  =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> speakers  =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> rear_viewMirror  =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> interiorStorage  =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> lights  =new HashMap<>();

    @OneToOne(fetch = FetchType.EAGER)
    InteriorEquipments interiorEquipments;
    @OneToOne
    Specs specs;
}
