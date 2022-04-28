package sprint1.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.Product;

import java.time.LocalDate;

@Getter
@Setter
public class PostResponseDTO {
    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;

    public PostResponseDTO(Post post) {
        this.postId = post.getPostId();
        this.date = post.getDate();
        this.detail = post.getDetail();
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
