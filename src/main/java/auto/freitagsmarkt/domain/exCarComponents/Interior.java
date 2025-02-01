package auto.cc.info.domain.exCarComponents;

import auto.cc.info.domain.BaseEntity;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;


@Entity
@Getter
@Setter
public class Interior extends BaseEntity {

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String instrumentCluster;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String connectivity;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String climateControl;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String displays;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String speakers;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String rear_viewMirror;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String interiorStorage;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String lights;
    @OneToOne(fetch = FetchType.EAGER)
    InteriorEquipments interiorEquipments;

}
