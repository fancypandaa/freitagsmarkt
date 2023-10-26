package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
@NoArgsConstructor
@Getter
@Setter
public class SuspensionsCommand {
    private Long id;

    private String springFront;
    private String springRear;
    private String anti_rollBar;
    private HashMap<String,String> suspensionRear =new HashMap<>();
    private HashMap<String,String> suspensionFront =new HashMap<>();
}
