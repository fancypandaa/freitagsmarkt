package auto.cc.info.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserCommand {
    private  String id;
    private String userName;
    private String password;
    private String role;
    private  String email;
}
