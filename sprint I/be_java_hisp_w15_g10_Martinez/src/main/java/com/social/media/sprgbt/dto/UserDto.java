package com.social.media.sprgbt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto implements Comparable<UserDto> {

    /**
     * Hace referencia a la clave primaria de la tabla User
     */
    private Integer userId;

    /**
     * Hace referencia al nombre del usuario.
     */
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
     * Hace referencia a la lista de todos los vendedores seguidos por un usuario.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UserDto> followed;

    /**
     * CompareTo
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
