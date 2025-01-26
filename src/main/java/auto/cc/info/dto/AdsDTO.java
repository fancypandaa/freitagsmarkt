package auto.cc.info.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class AdsCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    private Integer daysOfSale;
    private String Status;
    private Date published;
    private Long sellerId;
    private Long carId;
}
