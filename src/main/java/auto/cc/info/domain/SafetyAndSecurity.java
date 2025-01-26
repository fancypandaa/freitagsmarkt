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
public class SafetyAndSecurity extends BaseEntity{
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String seatBelt ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String assistSystems ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb",nullable = false)
    private String brakeSystem ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String sensors ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String safetyTesting ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb",nullable = false)
    private String airbags ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String childProtection ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String othersFeatures ;

}
