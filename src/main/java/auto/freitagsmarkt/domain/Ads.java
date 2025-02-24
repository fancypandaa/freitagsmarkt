package auto.freitagsmarkt.domain;

import auto.freitagsmarkt.domain.car.Car;
import auto.freitagsmarkt.domain.enums.AdsStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.*;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Ads extends BaseEntity  {
    @Min(1)
    @Max(365)
    private Integer daysOfSale;
    @Enumerated(EnumType.STRING)
    private AdsStatus status;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date published;
    @ManyToOne
    private Seller seller;
    @OneToOne(fetch = FetchType.EAGER)
    private Car car;
}
