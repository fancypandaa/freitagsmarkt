package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class TransmissionCommand {
    private Long id;
    private String driveTrain;
    private String transmission;

}
