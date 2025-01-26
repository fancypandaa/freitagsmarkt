package auto.cc.info.dto.car.otherComponents;


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
     InteriorEquipmentsCommand interiorEquipments
        ){
}
