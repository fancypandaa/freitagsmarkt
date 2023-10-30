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
public class DimensionsAndWeight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    Exterior mm
    private Float length;
    private Float width;
    private Float widthWithMirrors;
    private Float height;
    private Float trackFront;
    private Float trackRear;
    private Float wheelBase;
    private Float overhangFront;
    private Float overhangRear;
    private Float turningCircle;
    private Float groundClearance;
//    Interior mm
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,Float> interior =new HashMap<>();
//    Weight KG
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,Float> weight =new HashMap<>();
}
