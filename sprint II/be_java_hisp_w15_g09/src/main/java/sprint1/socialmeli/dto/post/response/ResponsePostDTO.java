package sprint1.socialmeli.dto.post.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.Product;

import java.time.LocalDate;

@Getter
@Setter
public class ResponsePostDTO {
    protected Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    protected LocalDate date;
    protected Product detail;
    protected Integer category;
    protected Double price;

    public ResponsePostDTO(Post post) {
        this.postId = post.getPostId();
        this.date = post.getDate();
        this.detail = post.getDetail();
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
