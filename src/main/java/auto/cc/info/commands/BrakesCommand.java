package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class BrakesCommand {

    private Long id;
    private String parkingBrake;
    private String manual;
    private String frontBrakes;
    private String cooling;
    private String rearBrakes;
}
