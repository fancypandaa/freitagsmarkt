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
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Interior extends BaseEntity{

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String instrumentCluster;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String connectivity;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String climateControl;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String displays;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String speakers;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String rear_viewMirror;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String interiorStorage;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String lights;
    @OneToOne(fetch = FetchType.EAGER)
    InteriorEquipments interiorEquipments;

}
