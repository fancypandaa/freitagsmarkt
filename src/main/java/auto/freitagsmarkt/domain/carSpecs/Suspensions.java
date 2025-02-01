package auto.cc.info.domain.carSpecs;

import auto.cc.info.domain.BaseEntity;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter

public class Suspensions extends BaseEntity {

    private String springFront;
    private String springRear;
    private String anti_rollBar;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String suspensionRear;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String suspensionFront;
}
