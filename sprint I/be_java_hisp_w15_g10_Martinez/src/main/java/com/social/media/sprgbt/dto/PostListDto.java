package com.social.media.sprgbt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostListDto {

    /**
     * Hace Referencia a la relacion entre el vendedor y las publicaciones.
     */
    private Integer userId;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonProperty("posts")
    List<PostDto> listPosts;


}
