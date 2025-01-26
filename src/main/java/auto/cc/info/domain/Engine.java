package auto.cc.info.domain;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
@Entity
@Getter
@Setter
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Engine extends BaseEntity{
    //     Engine Specification
    @Type(type = "jsonb")
    @Column(name="engine_specification",columnDefinition = "jsonb",nullable = false)
    private String engineSpecification;
    //     Engine Configuration
    @Type(type = "jsonb")
    @Column(name = "engine_configuration",columnDefinition = "jsonb",nullable = false)
    private String engineConfiguration;
    //     Engine Fluids
    @Type(type = "jsonb")
    @Column(name = "engine_fluids",columnDefinition = "jsonb")
    private String engineFluids;
    //     Service Intervals
    @Type(type = "jsonb")
    @Column(name = "service_intervals",columnDefinition = "jsonb")
    private String serviceIntervals;
    @OneToOne(cascade=CascadeType.ALL)
    Brakes brakes;
    @OneToOne(cascade=CascadeType.ALL)
    Suspensions suspensions;
    @OneToOne(cascade=CascadeType.ALL)
    Fuel fuel;
    @OneToOne(cascade=CascadeType.ALL)
    Transmission transmission;

}
