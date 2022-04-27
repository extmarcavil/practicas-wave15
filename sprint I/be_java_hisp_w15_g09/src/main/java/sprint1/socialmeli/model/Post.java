package sprint1.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.dto.PostRequestDTO;
import sprint1.socialmeli.dto.PostResponseDTO;
import sprint1.socialmeli.exceptions.InvalidPostException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private Integer userId;
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;

    public Post(PostResponseDTO dto) {
        userId = dto.getUserId();
        date = dto.getDate();
        detail = dto.getDetail();
        category = dto.getCategory();
        price = dto.getPrice();
    }

    public Post(PostRequestDTO post) {
        userId = post.getUserId();
        date = LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        detail = post.getDetail();
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
