package auto.freitagsmarkt.dto.specs;


import auto.freitagsmarkt.domain.enums.ChassisType;
import auto.freitagsmarkt.dto.components.ExteriorEquipmentDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;

@Builder
public record ExteriorDTO(
      Long exId ,
      @Enumerated(value = EnumType.STRING)
      ChassisType chassis ,
      Integer numberOfDoors ,
      String frontDoors ,
      String backDoors ,
      String platform ,
      String chassisOptions ,
      ExteriorEquipmentDTO exteriorEquipment
    ){
}
