package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Long userId;

    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Long postId;

    @NotNull(message = "La fecha no puede estar vacia")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String date;

    @NotNull
    @Valid
    private ProductDTO detail;

    @NotNull(message = "La categoria no puede estar vacia")
    private Integer category;

    @NotNull(message = "El precio no puede ser vacia")
    @Max(value = 10000000, message = "El precio no puede ser mayor a 10 millones")
    private Float price;

    public PostDTO(Post post) {
        this.userId = post.getUser().getUserId();
        this.postId = post.getPostId();
        this.date = post.getDate().toString();
        this.detail = new ProductDTO(post.getDetail());
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
