package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class CarBrandCommand {
    private Long id;
    private String name;
    private String countryOfOrigin;
    private String productionYears;
    private String series;
    private String logoUrl;
    private List<CarCommand> cars = new ArrayList<>();

}
