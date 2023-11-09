package auto.cc.info.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
public class DimensionsAndWeightCommand implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    private Long id;
//    Exterior mm
    private Float length;
    private Float width;
    private Float widthWithMirrors;
    private Float height;
    private Float trackFront;
    private Float trackRear;
    private Float wheelBase;
    private Float overhangFront;
    private Float overhangRear;
    private Float turningCircle;
    private Float groundClearance;
//    Interior mm
    private HashMap<String,Float> interior =new HashMap<>();
//    Weight KG
    private HashMap<String,Float> weight =new HashMap<>();

}
