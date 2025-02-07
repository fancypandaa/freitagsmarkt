package auto.freitagsmarkt.domain.carSpecs;

import auto.freitagsmarkt.domain.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transmission extends BaseEntity {

    private String driveTrain;
    private String transmission;
}
