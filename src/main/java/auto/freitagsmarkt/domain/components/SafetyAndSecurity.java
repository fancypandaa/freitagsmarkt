package auto.freitagsmarkt.domain.components;

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
public class SafetyAndSecurity extends BaseEntity {
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String seatBelt ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String assistSystems ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb",nullable = false)
    private String brakeSystem ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String sensors ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String safetyTesting ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb",nullable = false)
    private String airbags ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String childProtection ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String othersFeatures ;

}
