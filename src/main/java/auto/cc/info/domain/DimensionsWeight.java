package auto.cc.info.domain;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;


@Entity
@Getter
@Setter
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class DimensionsWeight extends BaseEntity{

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
    @Type(type = "jsonb")
    @Column(name = "interior", columnDefinition = "jsonb")
    private String interior;
//    Weight KG
    @Type(type = "jsonb")
    @Column(name = "weight", columnDefinition = "jsonb")
    private String weight;
}
