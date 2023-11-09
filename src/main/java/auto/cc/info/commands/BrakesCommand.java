package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class BrakesCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    private String parkingBrake;
    private String manual;
    @NotBlank
    private String frontBrakes;
    private String cooling;
    @NotBlank
    private String rearBrakes;
}
