package auto.cc.info.service;

import auto.cc.info.dto.UserCommand;

public interface UserService {
    UserCommand findUserByUserName(String userName,String password);
    UserCommand createNewUser(UserCommand userCommand);

    UserCommand findUserBySeller(String userName,String password,Long sellerId);
    UserCommand createNewSellerUser(UserCommand userCommand);
}
