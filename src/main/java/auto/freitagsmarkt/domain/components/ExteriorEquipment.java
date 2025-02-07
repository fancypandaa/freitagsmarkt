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
public class ExteriorEquipment extends BaseEntity {

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String sideMirrors;
    @Type(JsonBinaryType.class)
    @Column(name = "windscreen_wipers",columnDefinition = "jsonb")
    private String windscreenWipers;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String windows;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String lights;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String rimsAndTires;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String otherEquipments;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String tireDimensions;
    private String roofColour;
    private String accent;
    private String doorHandles;
}
