package auto.cc.info.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.*;
@Entity
@Getter
@Setter
public class CarBrand extends BaseEntity{

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

    public CarBrand setCars(Car car){
        car.setCarBrand(this);
        this.cars.add(car);
        return this;
    }

}
