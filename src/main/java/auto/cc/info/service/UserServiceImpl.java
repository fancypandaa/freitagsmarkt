package auto.cc.info.service;

import auto.cc.info.commands.UserCommand;
import auto.cc.info.converters.UserCommandToUser;
import auto.cc.info.converters.UserToUserCommand;
import auto.cc.info.domain.user.User;
import auto.cc.info.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.*;
@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserToUserCommand userToUserCommand;
    private final UserCommandToUser userCommandToUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserToUserCommand userToUserCommand, UserCommandToUser userCommandToUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Boolean findUserByUserName(String userName,String password) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUserName(userName));
        if(!userOptional.isPresent()){
            return null;
        }
        if(userOptional.get().getUserName() == userName && passwordEncoder.matches(password,userOptional.get().getPassword())){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    @RolesAllowed({"GUEST"})
    public UserCommand createNewUser(UserCommand userCommand) {
        User user = userCommandToUser.convert(userCommand);
        userRepository.save(user);
        return userCommand;
    }
}
