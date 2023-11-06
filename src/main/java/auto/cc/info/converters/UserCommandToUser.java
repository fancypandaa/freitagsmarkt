package auto.cc.info.converters;

import auto.cc.info.commands.UserCommand;
import auto.cc.info.domain.user.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUser implements Converter<UserCommand, User> {

    @Override
    @Synchronized
    @Nullable
    public User convert(UserCommand userCommand) {
        if (userCommand == null) {
            return null;
        }
        User user = new User();
        user.setUserName(userCommand.getUserName());
        user.setEmail(userCommand.getEmail());
        user.setPassword(userCommand.getPassword());
        user.setRole(userCommand.getRole());
        return user;
    }
}
