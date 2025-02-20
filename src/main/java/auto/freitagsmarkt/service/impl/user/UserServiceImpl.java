package auto.freitagsmarkt.service.impl.user;

import auto.freitagsmarkt.dto.user.UserDTO;
import auto.freitagsmarkt.mapper.user.UserMapper;
import auto.freitagsmarkt.repository.user.UserRepository;
import auto.freitagsmarkt.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    private UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findUserByUserName(String userName, String password) {
        return userRepository.findByUserName(userName)
                .map(userMapper::userToUserDTO)
                .orElseThrow(()-> new RuntimeException("Current user not Found"));
    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        return Optional.of(userDTO)
                .map(userMapper::userDTOtoUser)
                .map(userRepository::save)
                .map(userMapper::userToUserDTO)
                .orElseThrow(() -> new RuntimeException("User creation process failed!!"));
    }

    @Override
    public UserDTO findUserBySeller(String userName, String password, Long sellerId) {
        return null;
    }

    @Override
    public UserDTO createNewSellerUser(UserDTO userDTO) {
        return null;
    }
}
