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
public class Suspensions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String springFront;
    private String springRear;
    private String anti_rollBar;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> suspensionRear =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> suspensionFront =new HashMap<>();
}
