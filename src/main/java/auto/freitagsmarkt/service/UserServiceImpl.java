package auto.cc.info.service;

import auto.cc.info.dto.UserCommand;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public UserCommand findUserByUserName(String userName, String password) {
        return null;
    }

    @Override
    public UserCommand createNewUser(UserCommand userCommand) {
        return null;
    }

    @Override
    public UserCommand findUserBySeller(String userName, String password, Long sellerId) {
        return null;
    }

    @Override
    public UserCommand createNewSellerUser(UserCommand userCommand) {
        return null;
    }
}
