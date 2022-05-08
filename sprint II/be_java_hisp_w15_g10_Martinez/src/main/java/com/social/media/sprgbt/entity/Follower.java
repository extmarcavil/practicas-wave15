package com.social.media.sprgbt.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Follower {

    /**
     * clave primaria de la tabla Follower.
     */
    private Integer id;

    /**
     * Hace referencia al usuario seguidor (follower).
     */
    private Integer userId;

    /**
     * Hace referencia al usuario seguido (following)
     */
    private Integer userIdToFollow;


}
