package sprint2.socialmeli.utils;

import sprint2.socialmeli.dto.user.UserDTO;
import sprint2.socialmeli.model.User;

//@Component
public class UserConverter extends Converter<UserDTO,User> {

    public UserConverter() {
        super(UserConverter::convertToEntity, UserConverter::convertToDto);
    }

    private static UserDTO convertToDto(User entity) {
        return new UserDTO(entity);
    }

    private static User convertToEntity(UserDTO dto) {
        return new User(dto);
    }

}