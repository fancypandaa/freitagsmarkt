package auto.cc.info.domain.carSpecs;

import auto.cc.info.domain.BaseEntity;
import auto.cc.info.domain.exCarComponents.ExteriorEquipment;
import auto.cc.info.domain.enums.ChassisType;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;


@Entity
@Getter
@Setter
public class Exterior extends BaseEntity {
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ChassisType chassis;
    @Type(JsonBinaryType.class)
    @Column(name = "chassis_options",columnDefinition = "jsonb")
    private String chassisOptions;
    private String numberOfDoors;
    private String frontDoors;
    private String backDoors;
    private String platform;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    ExteriorEquipment exteriorEquipment;
}
