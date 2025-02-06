package auto.freitagsmarkt.domain.carSpecs;

import auto.freitagsmarkt.domain.BaseEntity;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;


@Entity
@Getter
@Setter
public class DimensionsWeight extends BaseEntity {
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
    @Type(JsonBinaryType.class)
    @Column(name = "interior", columnDefinition = "jsonb")
    private String interior;
//    Weight KG
    @Type(JsonBinaryType.class)
    @Column(name = "weight", columnDefinition = "jsonb")
    private String weight;
}
