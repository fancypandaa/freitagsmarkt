package auto.cc.info.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Specs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    Engine engine;
    @OneToOne
    DimensionsAndWeight dimensionsAndWeight;
    @OneToOne
    Exterior exterior;
    @OneToOne
    Interior interior;
    @OneToOne
    Features features;
    @OneToOne
    SafetyAndSecurity safetyAndSecurity;
}
