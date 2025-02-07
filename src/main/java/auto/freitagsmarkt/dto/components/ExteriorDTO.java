package auto.freitagsmarkt.dto.components;


import auto.freitagsmarkt.domain.enums.ChassisType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;

@Builder
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
