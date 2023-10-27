package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
@NoArgsConstructor
@Getter
@Setter
public class SellerCommand {
    private Long id;
    private String type;
    private String name;
    private String phone;
    private String sellerWebsite;
    private List<AdsCommand> ads= new ArrayList<>();
    private Set<CarCommand> cars=new HashSet<>();

}
