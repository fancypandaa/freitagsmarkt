package auto.freitagsmarkt.domain.specs;

import auto.freitagsmarkt.domain.BaseEntity;
import auto.freitagsmarkt.domain.othersComponents.Brakes;
import auto.freitagsmarkt.domain.othersComponents.Fuel;
import auto.freitagsmarkt.domain.othersComponents.Suspensions;
import auto.freitagsmarkt.domain.othersComponents.Transmission;
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
    @Type(JsonBinaryType.class)
    @Column(name = "performance",columnDefinition = "jsonb")
    private String performance;
    @OneToOne(cascade=CascadeType.ALL)
    Brakes brakes;
    @OneToOne(cascade= CascadeType.ALL)
    Suspensions suspensions;
    @OneToOne(cascade=CascadeType.ALL)
    Fuel fuel;
    @OneToOne(cascade=CascadeType.ALL)
    Transmission transmission;

}
