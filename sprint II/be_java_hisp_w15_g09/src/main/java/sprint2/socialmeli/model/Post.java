package sprint2.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint2.socialmeli.dto.post.request.RequestPostDTO;
import sprint2.socialmeli.exceptions.InvalidPostException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private Integer postId;
    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;

    public Post(RequestPostDTO post) {
        userId = post.getUserId();
        date = LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        detail = new Product(post.getDetail());
        category = post.getCategory();
        price = post.getPrice();
        isAValidPost();
    }

    public boolean hasUserID(int IDToMatch) {
        return userId.equals(IDToMatch);
    }

    private void isAValidPost(){
        if (    this.userId == null     ||
                this.date == null       ||
                this.detail== null      ||
                this.category == null   ||
                this.price == null      ){
            throw new InvalidPostException("El post contiene campos incompletos.");
        }
    }

}
