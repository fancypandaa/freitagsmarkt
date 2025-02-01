package auto.cc.info.dto;

import lombok.Builder;

@Builder
public record UserDTO(
      String id,
     String userName,
     String password,
     String role,
      String email
){
}
