package auto.cc.info.domain;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Getter
@Setter
@TypeDef(
        name = "json", typeClass = JsonType.class
)
public class SafetyAndSecurity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> seatBelt =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,Boolean> assistSystems =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json",nullable = false)
    private HashMap<String,String> brakeSystem =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> sensors =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> safetyTesting =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json",nullable = false)
    private HashMap<String,String> airbags =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> childProtection =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> othersFeatures =new HashMap<>();

}
