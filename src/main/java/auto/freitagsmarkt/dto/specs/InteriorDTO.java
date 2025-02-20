package auto.freitagsmarkt.dto.specs;

import auto.freitagsmarkt.dto.components.InteriorEquipmentsDTO;
import lombok.Builder;

@Builder
public record InteriorDTO(
     Long interiorId,
     String instrumentCluster,
     String connectivity,
     String climateControl,
     String displays,
     String speakers,
     String rear_viewMirror,
     String interiorStorage,
     String lights,
     InteriorEquipmentsDTO interiorEquipments
        ){
}
