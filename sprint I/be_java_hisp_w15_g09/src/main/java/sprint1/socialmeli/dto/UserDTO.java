package sprint1.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.User;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private Integer userId;
    private String userName;

    public UserDTO(User entity) {
        entity.mapToDTO(this);
    }
}
