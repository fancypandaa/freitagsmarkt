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
@TypeDef(
        name = "jsonb", typeClass = JsonBinaryType.class
)
public class Suspensions extends BaseEntity{

    private String springFront;
    private String springRear;
    private String anti_rollBar;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String suspensionRear;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String suspensionFront;
}
