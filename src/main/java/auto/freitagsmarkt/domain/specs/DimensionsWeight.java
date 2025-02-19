package auto.freitagsmarkt.domain.specs;

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
    @Type(JsonBinaryType.class)
    @Column(name = "exterior", columnDefinition = "jsonb")
    private String exterior;
    @Type(JsonBinaryType.class)
    @Column(name = "interior", columnDefinition = "jsonb")
    private String interior;
    @Type(JsonBinaryType.class)
    @Column(name = "weight", columnDefinition = "jsonb")
    private String weight;
    @Type(JsonBinaryType.class)
    @Column(name = "lcvSpecific", columnDefinition = "jsonb")
    private String lcvSpecific;
}
