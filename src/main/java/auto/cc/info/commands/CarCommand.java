package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
public class CarCommand {
    private Long id;
    private String model;
    private String city;
    private String days;
    private String price;
    private String mileage;
    private String generation;
    private Long carBrandId;
    //    private List<SellerCommand> sellerCommands = new ArrayList<>();
    private SpecsCommand specsCommand;
}
