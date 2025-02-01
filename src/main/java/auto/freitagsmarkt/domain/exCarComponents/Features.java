package auto.cc.info.domain.exCarComponents;

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
public class Features extends BaseEntity {


    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String comfort;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String accessories;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String others;
}

