package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
@NoArgsConstructor
@Getter
@Setter
public class SuspensionsCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    private String springFront;
    private String springRear;
    private String anti_rollBar;
    private HashMap<String,String> suspensionRear =new HashMap<>();
    private HashMap<String,String> suspensionFront =new HashMap<>();
}
