package auto.cc.info.dto.car.otherComponents;


import auto.cc.info.domain.enums.ChassisType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record ExteriorDTO(
      Long id ,
    @Enumerated(value = EnumType.STRING)
      ChassisType chassis ,
      String numberOfDoors ,
      String frontDoors ,
      String backDoors ,
      String platform ,
      String chassisOptions ,
      ExteriorEquipmentDTO exteriorEquipment
    ){
}
