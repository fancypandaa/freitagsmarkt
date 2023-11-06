package auto.cc.info.service;

import auto.cc.info.commands.UserCommand;
import auto.cc.info.domain.user.User;

public interface UserService {
    Boolean findUserByUserName(String userName,String password);
    UserCommand createNewUser(UserCommand userCommand);
}
