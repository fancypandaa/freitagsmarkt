package auto.cc.info.domain;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
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
        name = "jsonb", typeClass = JsonBinaryType.class
)
public class Features extends BaseEntity{


    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String comfort;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String accessories;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String others;
}

