package auto.freitagsmarkt.domain.othersComponents;

import auto.freitagsmarkt.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Brakes extends BaseEntity {

    private String parkingBrake;
    private String manual;
    @Column(nullable = false)
    private String frontBrakes;
    private String cooling;
    @Column(nullable = false)
    private String rearBrakes;

}
