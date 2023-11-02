package auto.cc.info.domain;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.*;
@Entity
@Getter
@Setter
@TypeDef(
        name = "json", typeClass = JsonType.class
)
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //     Engine Specification
    @Type(type = "json")
    @Column(columnDefinition = "json",nullable = false)
    private HashMap<String,Integer> engineSpecification= new HashMap<>();
    //     Engine Configuration
    @Type(type = "json")
    @Column(columnDefinition = "json",nullable = false)
    private HashMap<String,String> engineConfiguration= new HashMap<>();
    //     Engine Fluids
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> engineFluids= new HashMap<>();
    //     Service Intervals
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> serviceIntervals= new HashMap<>();

    @OneToOne
    Brakes brakes;
    @OneToOne
    Suspensions suspensions;
    @OneToOne
    Fuel fuel;
    @OneToOne
    Transmission transmission;


}
