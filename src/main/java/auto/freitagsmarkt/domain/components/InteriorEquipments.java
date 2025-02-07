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

public class InteriorEquipments extends BaseEntity {
  
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String steeringWheels ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String trunk ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String design ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String seats ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String rimsAndTires ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String otherEquipments ;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String tireDimensions ;
}
