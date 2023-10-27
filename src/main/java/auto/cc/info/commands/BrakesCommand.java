package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class BrakesCommand {

    private Long id;
    private String parkingBrake;
    private String manual;
    @NotBlank
    private String frontBrakes;
    private String cooling;
    @NotBlank
    private String rearBrakes;
}
