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
    @OneToOne(fetch = FetchType.EAGER)
    Engine engine;
    @OneToOne(fetch = FetchType.EAGER)
    DimensionsAndWeight dimensionsAndWeight;
    @OneToOne(fetch = FetchType.EAGER)
    Exterior exterior;
    @OneToOne(fetch = FetchType.EAGER)
    Interior interior;
    @OneToOne(fetch = FetchType.EAGER)
    Features features;
    @OneToOne(fetch = FetchType.EAGER)
    SafetyAndSecurity safetyAndSecurity;

    @OneToOne
    private Car car;
}
