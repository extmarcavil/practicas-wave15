package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostListDTO {
    private Long userId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;
    private List<PostDTO> posts;

    public PostListDTO(Long userId, List<PostDTO> posts) {
        this(userId, null, posts);
    }
}