package auto.cc.info.domain;

import lombok.Getter;
import lombok.Setter;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@TypeDef(
        name = "json", typeClass = JsonType.class
)
public class ExteriorEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String,String> sideMirrors =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String,String> windscreenWipers =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String,String> windows =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String,String> lights =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String,String> rimsAndTires =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String,String> otherEquipments =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String,String> tireDimensions =new HashMap<>();

    private String roofColour;
    private String accent;
    private String doorHandles;
    @OneToOne
    Exterior exterior;
}
