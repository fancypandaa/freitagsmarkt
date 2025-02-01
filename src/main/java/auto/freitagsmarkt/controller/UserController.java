package auto.cc.info.controller;

import auto.cc.info.dto.UserCommand;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.security.JwtGenerator;
import auto.cc.info.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("/api/sellerUser")
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
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER_GUEST)
    public String addNewSellerUser(@RequestBody UserCommand userCommand){
        userCommand.setRole("SELLER");
        userCommand.setPassword(passwordEncoder.encode(userCommand.getPassword()));
        Optional<UserCommand> userCommandOptional = Optional.ofNullable(userService.createNewSellerUser(userCommand));
        if(!userCommandOptional.isPresent()){
            log.error("Your new seller not added failed process !!!");
            return null;
        }
        else {
            return jwtGenerator.generate(userCommand);
        }
    }
    @RolesAllowed({Constants.SELLER_GUEST,Constants.SELLER})
    @RequestMapping(value ="/{sellerId}/{userName}/{password}",method = RequestMethod.GET,produces = "application/json")
    public String loginSeller(@PathVariable Long sellerId, @PathVariable String userName,@PathVariable String password){

        UserCommand userCommandI = userService.findUserBySeller(userName,
                password, sellerId);
        if(userCommandI == null){
            return null;
        }
        return jwtGenerator.generate(userCommandI);
    }
    @MutationMapping("createUser")
    @RolesAllowed(Constants.GUEST)
    public String createUser(@Argument String userName,@Argument String email,@Argument String password){
        UserCommand userCommand = new UserCommand();
        userCommand.setUserName(userName);
        userCommand.setEmail(email);
        userCommand.setPassword(passwordEncoder.encode(password));
        userCommand.setRole("USER");
        userService.createNewUser(userCommand);
        return jwtGenerator.generate(userCommand);
    }
    @MutationMapping("login")
    @RolesAllowed({Constants.GUEST,Constants.USER})
    public String login(@Argument String userName,@Argument String password){
        UserCommand userCommand = userService.findUserByUserName(userName,passwordEncoder.encode(password));
        if(userCommand == null){
            return null;
        }
        return jwtGenerator.generate(userCommand);
    }
}
