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
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> comfort  =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,Boolean> accessories  =new HashMap<>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HashMap<String,String> others  =new HashMap<>();
    @OneToOne
    Specs specs;
}

