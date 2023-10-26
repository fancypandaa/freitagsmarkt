package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class AdsCommand {
    private Long id;
    private Integer daysOfSale;
    private String Status;
    private Date published;
    private Long sellerId;
    private CarCommand carCommand;
}
