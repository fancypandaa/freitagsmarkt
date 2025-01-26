package auto.cc.info.dto.car.otherComponents;


import auto.cc.info.domain.enums.ChassisType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public record ExteriorDTO(
      Long id ,
    @Enumerated(value = EnumType.STRING)
      ChassisType chassis ,
      String numberOfDoors ,
      String frontDoors ,
      String backDoors ,
      String platform ,
      String chassisOptions ,
      ExteriorEquipmentCommand exteriorEquipment
    ){
}
