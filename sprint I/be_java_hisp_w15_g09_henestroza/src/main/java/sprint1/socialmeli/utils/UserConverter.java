package sprint1.socialmeli.utils;

import org.springframework.stereotype.Component;
import sprint1.socialmeli.dtos.UserDTO;
import sprint1.socialmeli.model.User;

@Component
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