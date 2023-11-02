package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class CarBrandCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    private String name;
    private String countryOfOrigin;
    private Integer productionYears;
    private String series;
    private String logoUrl;
    private List<CarCommand> cars = new ArrayList<>();

}
