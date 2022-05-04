package sprint2.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint2.socialmeli.model.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    @NotNull(message = "El  id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer userId;
    private String userName;

    public UserDTO(User entity) {
        entity.mapToDTO(this);
    }
}
