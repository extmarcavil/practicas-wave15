package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.bcel.Const;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {

    @NotNull(message = Constants.ID_NOT_NULL)
    @Min(value = Constants.ID_VALUE, message = Constants.ID_NOT_ZERO)
    private Long userId;

    @NotNull(message = Constants.ID_NOT_NULL)
    @Min(value = Constants.ID_VALUE, message = Constants.ID_NOT_ZERO)
    private Long postId;

    @NotBlank(message = Constants.DATE_NOT_NULL)
    @Pattern(regexp = Constants.DATE_REGEX, message = Constants.DATE_FORMAT)
    private String date;

    @NotNull(message = Constants.DETAIL_NOT_NULL)
    @Valid
    private ProductDTO detail;

    @NotNull(message = Constants.CATEGORY_NOT_NULL)
    private Integer category;

    @NotNull(message = Constants.PRICE_NOT_NULL)
    @Max(value = Constants.PRICE_VALUE, message = Constants.PRICE_MAX_VALUE)
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
