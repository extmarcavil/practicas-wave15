package sprint1.socialmeli.dto;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.Product;

import java.time.LocalDate;

@Getter
@Setter
public class PostResponseDTO {
    private Integer userId;
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;

    public PostResponseDTO(Post post) {
        this.userId = post.getUserId();
        this.date = post.getDate();
        this.detail = post.getDetail();
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
