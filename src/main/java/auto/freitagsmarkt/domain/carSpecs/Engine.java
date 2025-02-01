package auto.cc.info.domain.carSpecs;

import auto.cc.info.domain.BaseEntity;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;


@Entity
@Getter
@Setter
public class Engine extends BaseEntity {
    //     Engine Specification
    @Type(JsonBinaryType.class)
    @Column(name="engine_specification",columnDefinition = "jsonb",nullable = false)
    private String engineSpecification;
    //     Engine Configuration
    @Type(JsonBinaryType.class)
    @Column(name = "engine_configuration",columnDefinition = "jsonb",nullable = false)
    private String engineConfiguration;
    //     Engine Fluids
    @Type(JsonBinaryType.class)
    @Column(name = "engine_fluids",columnDefinition = "jsonb")
    private String engineFluids;
    //     Service Intervals
    @Type(JsonBinaryType.class)
    @Column(name = "service_intervals",columnDefinition = "jsonb")
    private String serviceIntervals;
    @OneToOne(cascade=CascadeType.ALL)
    Brakes brakes;
    @OneToOne(cascade= CascadeType.ALL)
    Suspensions suspensions;
    @OneToOne(cascade=CascadeType.ALL)
    Fuel fuel;
    @OneToOne(cascade=CascadeType.ALL)
    Transmission transmission;

}
