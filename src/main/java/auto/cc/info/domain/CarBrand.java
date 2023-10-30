package auto.cc.info.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
@Entity
@Getter
@Setter
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true,nullable = false)
    private String name;
    private String countryOfOrigin;
    private String productionYears;
    private String series;
    private String logoUrl;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "carBrand")
    private List<Car> cars = new ArrayList<>();

    public CarBrand setCars(Car car){
        car.setCarBrand(this);
        this.cars.add(car);
        return this;
    }

}
