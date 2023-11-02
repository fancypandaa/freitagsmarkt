package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
public class FeaturesCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    private HashMap<String,String> comfort  =new HashMap<>();
    private HashMap<String,String> accessories  =new HashMap<>();
    private HashMap<String,String> others  =new HashMap<>();
}

