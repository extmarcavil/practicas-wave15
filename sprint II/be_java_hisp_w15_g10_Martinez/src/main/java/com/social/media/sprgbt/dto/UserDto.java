package com.social.media.sprgbt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto implements Comparable<UserDto> {

    /**
     * Hace referencia a la clave primaria de la tabla User
     */
    //@NotBlank(message = "Atributo no puede ser Null o Vacio")
    private Integer userId;

    /**
     * Hace referencia al nombre del usuario.
     */
    @Size(max = 15, message = "Longitud maxima del nombre 15 caracteres")
    private String userName;

    /**
     * Hace referencia a la cantidad de seguidores que tiene un vendedor.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer followersCount;

    /**
     * Hace referencia a la lista de todos los seguidores que tiene un vendedor.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UserDto> followers;

    /**
     * Hace referencia a la lista de todos los vendedores seguidos por el usuario.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UserDto> followed;

    /**
     * CompareTo
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(UserDto o) {
        if (this.getUserName() == null || o.getUserName() == null) {
            return 0;
        }
        return this.getUserName().compareTo(o.getUserName());

    }
}
