package auto.cc.info.domain;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@TypeDef(name = "jsonb",typeClass = JsonBinaryType.class)
public class ExteriorEquipment extends BaseEntity{

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String sideMirrors;
    @Type(type = "jsonb")
    @Column(name = "windscreen_wipers",columnDefinition = "jsonb")
    private String windscreenWipers;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String windows;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String lights;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String rimsAndTires;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String otherEquipments;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String tireDimensions;
    private String roofColour;
    private String accent;
    private String doorHandles;
}
