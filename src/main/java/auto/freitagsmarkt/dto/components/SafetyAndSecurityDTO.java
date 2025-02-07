package auto.freitagsmarkt.dto.components;

import lombok.Builder;

@Builder
public record SafetyAndSecurityDTO (
     Long id,
     String seatBelt  ,
    String assistSystems  ,
     String brakeSystem  ,
     String sensors  ,
     String safetyTesting  ,
     String airbags  ,
     String childProtection  ,
     String othersFeatures ){
}
