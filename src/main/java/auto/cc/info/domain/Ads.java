package auto.cc.info.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.*;
@Entity
@Getter
@Setter
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1)
    @Max(365)
    private Integer daysOfSale;
    private String status;
    private Date published;
    @ManyToOne
    Seller seller; // **
    @OneToOne(fetch = FetchType.EAGER)
    Car car;
}
