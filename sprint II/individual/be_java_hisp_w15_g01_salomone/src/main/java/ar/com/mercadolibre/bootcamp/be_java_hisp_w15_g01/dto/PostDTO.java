package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private Long userId;
    private Long postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String date;
    private ProductDTO detail;
    private Integer category;
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