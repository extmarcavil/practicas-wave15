package sprint2.socialmeli.dto.post.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import sprint2.socialmeli.model.Post;
import sprint2.socialmeli.model.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
public class ResponsePostDTO {
    @NotBlank(message = "El id_post no puede estar vacío.")
    @Positive(message = "El id_post debe ser mayor a cero")
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
