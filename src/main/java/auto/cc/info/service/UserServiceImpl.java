package auto.cc.info.service;

import auto.cc.info.commands.UserCommand;
import auto.cc.info.converters.UserCommandToUser;
import auto.cc.info.converters.UserToUserCommand;
import auto.cc.info.domain.Seller;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.domain.user.User;
import auto.cc.info.repository.SellerRepository;
import auto.cc.info.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.*;
@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserToUserCommand userToUserCommand;
    private final UserCommandToUser userCommandToUser;
    private final PasswordEncoder passwordEncoder;
    private final SellerRepository sellerRepository;

    public UserServiceImpl(UserRepository userRepository, UserToUserCommand userToUserCommand, UserCommandToUser userCommandToUser, PasswordEncoder passwordEncoder, SellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
        this.passwordEncoder = passwordEncoder;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public UserCommand findUserByUserName(String userName,String password) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUserName(userName));
        if(!userOptional.isPresent()){
            return null;
        }
        if(userOptional.get().getUserName().equals(userName)  && passwordEncoder.matches(password,userOptional.get().getPassword())){
            return userToUserCommand.convert(userOptional.get());
        }
        return null;
    }

    @Override
    @RolesAllowed({Constants.GUEST})
    public UserCommand createNewUser(UserCommand userCommand) {
        User user = userCommandToUser.convert(userCommand);
        userRepository.save(user);
        return userCommand;
    }

    @Override
    @Transactional
     public UserCommand findUserBySeller(String userName, String password, Long sellerId) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUserName(userName));
        if(!userOptional.isPresent()){
            return null;
        }
        boolean result = passwordEncoder.matches(password, userOptional.get().getPassword());
        if(userOptional.get().getUserName().equals(userName)  && passwordEncoder.matches(password,userOptional.get().getPassword())){
            Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
            if(sellerOptional.isPresent()){
                return userToUserCommand.convert(userOptional.get());
            }
            else {
                return null;
            }
        }
        return null;
    }

    @Override
    public UserCommand createNewSellerUser(UserCommand userCommand) {
        User user = userCommandToUser.convert(userCommand);
        userRepository.save(user);
        return userCommand;
    }
}
