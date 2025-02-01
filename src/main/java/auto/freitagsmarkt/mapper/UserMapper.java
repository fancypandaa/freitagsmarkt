package auto.cc.info.mapper;

import auto.cc.info.domain.user.User;
import auto.cc.info.dto.UserDTO;
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
