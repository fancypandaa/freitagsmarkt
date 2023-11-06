package auto.cc.info.converters;

import auto.cc.info.commands.UserCommand;
import auto.cc.info.domain.user.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User, UserCommand> {
    @Override
    @Synchronized
    @Nullable
    public UserCommand convert(User source) {
        if (source == null) {
            return null;
        }
        UserCommand userCommand = new UserCommand();
        userCommand.setUserName(source.getUserName());
        userCommand.setEmail(source.getEmail());
        userCommand.setPassword(source.getPassword());
        userCommand.setRole(source.getRole());
        return userCommand;
    }
}
