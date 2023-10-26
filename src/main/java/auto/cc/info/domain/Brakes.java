package auto.cc.info.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
@Getter
@Setter
public class Brakes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String parkingBrake;
    private String manual;
    @Column(nullable = false)
    private String frontBrakes;
    private String cooling;
    @Column(nullable = false)
    private String rearBrakes;
    @OneToOne
    Engine engine;
}
