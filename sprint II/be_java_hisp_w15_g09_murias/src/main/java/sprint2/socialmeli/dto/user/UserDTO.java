package sprint2.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sprint2.socialmeli.model.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer userId;
    private String userName;

    public UserDTO(User entity) {
        entity.mapToDTO(this);
    }

}
