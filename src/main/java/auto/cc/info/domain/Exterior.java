package auto.cc.info.domain;

import auto.cc.info.domain.enums.ChassisType;
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
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Exterior extends BaseEntity{
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ChassisType chassis;
    @Type(type = "jsonb")
    @Column(name = "chassis_options",columnDefinition = "jsonb")
    private String chassisOptions;
    private String numberOfDoors;
    private String frontDoors;
    private String backDoors;
    private String platform;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    ExteriorEquipment exteriorEquipment;
}
