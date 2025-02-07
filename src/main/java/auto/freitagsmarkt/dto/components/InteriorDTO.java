package auto.freitagsmarkt.dto.components;

import lombok.Builder;

@Builder
public record InteriorDTO(
     Long id,
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
