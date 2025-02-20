package auto.freitagsmarkt.dto.specs;

import lombok.Builder;

@Builder
public record SafetyAndSecurityDTO (
     Long safetyId,
     String seatBelt  ,
    String assistSystems  ,
     String brakeSystem  ,
     String sensors  ,
     String safetyTesting  ,
     String airbags  ,
     String childProtection  ,
     String othersFeatures ){
}
