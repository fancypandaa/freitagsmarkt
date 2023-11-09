package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
public class SafetyAndSecurityCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
    private HashMap<String,String> seatBelt =new HashMap<>();
    private HashMap<String,Boolean> assistSystems =new HashMap<>();
    private HashMap<String,String> brakeSystem =new HashMap<>();
    private HashMap<String,String> sensors =new HashMap<>();
    private HashMap<String,String> safetyTesting =new HashMap<>();
    private HashMap<String,String> airbags =new HashMap<>();
    private HashMap<String,String> childProtection =new HashMap<>();
    private HashMap<String,String> othersFeatures =new HashMap<>();

}
