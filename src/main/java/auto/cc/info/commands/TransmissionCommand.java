package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
public class TransmissionCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    private String driveTrain;
    private String transmission;
}
