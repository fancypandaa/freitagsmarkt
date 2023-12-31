package auto.cc.info.commands;

import auto.cc.info.domain.SellerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;
@NoArgsConstructor
@Getter
@Setter
public class SellerCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    private SellerType type;
    private String name;
    private String phone;
    private String sellerWebsite;
    private List<AdsCommand> ads= new ArrayList<>();
    private List<CarCommand> cars=new ArrayList<>();
    private Long userId;

}
