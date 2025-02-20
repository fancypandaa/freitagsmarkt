package auto.freitagsmarkt.service.user;


import auto.freitagsmarkt.dto.user.UserDTO;

public interface UserService {
    UserDTO findUserByUserName(String userName, String password);
    UserDTO createNewUser(UserDTO userDTO);
    UserDTO findUserBySeller(String userName,String password,Long sellerId);
    UserDTO createNewSellerUser(UserDTO userDTO);
}
