package auto.freitagsmarkt.mapper.user;

import auto.freitagsmarkt.domain.user.User;
import auto.freitagsmarkt.dto.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO userToUserDTO(User user);
    User userDTOtoUser(UserDTO userDTO);
    void updateUserFromUserDTO(UserDTO userDTO, @MappingTarget User user);
}
