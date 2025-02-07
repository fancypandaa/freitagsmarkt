package auto.freitagsmarkt.domain.car;

import auto.freitagsmarkt.domain.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class CarBrand extends BaseEntity {

    @Column(unique=true,nullable = false)
    private String name;
    private String countryOfOrigin;
    @Min(1800)
    private Integer productionYears;
    @Min(1)
    private Integer series;
    private String logoUrl;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "carBrand")
    private List<Car> cars = new ArrayList<>();

    public void setCars(Car car){
        if(car != null && this.cars.contains(car)){
            this.cars.add(car);
        }
    }

}
