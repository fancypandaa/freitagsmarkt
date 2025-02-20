package auto.freitagsmarkt.controller.user;

import auto.freitagsmarkt.domain.user.Constants;
import auto.freitagsmarkt.dto.user.UserDTO;
import auto.freitagsmarkt.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping()
public class UserController {
    private static final String USER_URI = "/api/user";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/signUp")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(userDTO));
    }
    @PostMapping("/signIn")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userDTO);
    }
}
