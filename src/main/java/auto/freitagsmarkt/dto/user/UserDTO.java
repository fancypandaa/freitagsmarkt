package auto.freitagsmarkt.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record UserDTO(
        @JsonInclude(value = JsonInclude.Include.NON_NULL)
        String id,
     String userName,
     String password,
     @JsonInclude(value = JsonInclude.Include.NON_NULL)
     String role,
      @JsonInclude(value = JsonInclude.Include.NON_NULL)
      String email
){
}
