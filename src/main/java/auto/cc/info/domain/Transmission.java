package auto.cc.info.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Transmission extends BaseEntity{

    private String driveTrain;
    private String transmission;
}
