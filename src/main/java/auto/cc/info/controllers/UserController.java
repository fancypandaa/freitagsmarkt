package auto.cc.info.controllers;

import auto.cc.info.commands.UserCommand;
import auto.cc.info.security.JwtGenerator;
import auto.cc.info.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@Slf4j
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtGenerator jwtGenerator;

    public UserController(PasswordEncoder passwordEncoder, UserService userService, JwtGenerator jwtGenerator) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
    }
    @MutationMapping("createUser")
    public String createUser(@Argument String userName,@Argument String email,@Argument String password){
        UserCommand userCommand = new UserCommand();
        userCommand.setUserName(userName);
        userCommand.setEmail(email);
        userCommand.setPassword(passwordEncoder.encode(password));
        userCommand.setRole("USER");
        userService.createNewUser(userCommand);
        return jwtGenerator.generate(userCommand);
    }
}
