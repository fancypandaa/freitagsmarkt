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
public class InteriorEquipments extends BaseEntity{
  
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String steeringWheels ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String trunk ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String design ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String seats ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String rimsAndTires ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String otherEquipments ;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String tireDimensions ;
}
