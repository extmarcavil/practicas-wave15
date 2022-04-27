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
        this.userId = dto.getUserId();
        this.date = dto.getDate();
        this.detail = dto.getDetail();
        this.category = dto.getCategory();
        this.price = dto.getPrice();
        //this.isAValidPost();
    }

    public Post(PostRequestDTO post) {
        this.userId = post.getUserId();
        this.date = LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.detail = post.getDetail();
        this.category = post.getCategory();
        this.price = post.getPrice();
        this.isAValidPost();
    }

    public boolean hasUserID(int IDToMatch) {
        return userId.equals(IDToMatch);
    }

    private void isAValidPost(){
        // Validar y si no pasa, tirar BAD_REQUEST
        if (    this.userId == null     ||
                this.date == null       ||
                this.detail== null      ||
                this.category == null   ||
                this.price == null      ){
            throw new InvalidPostException("El post contiene campos incompletos.");
        }
    }
}
