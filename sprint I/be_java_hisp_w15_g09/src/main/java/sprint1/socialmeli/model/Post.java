package sprint1.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.dto.PostRequestDTO;
import sprint1.socialmeli.dto.PromoPostRequestDTO;
import sprint1.socialmeli.exceptions.InvalidPostException;

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
    private boolean hasPromo;
    private Double discount;

    public Post(PostRequestDTO post) {
        userId = post.getUserId();
        date = LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        detail = post.getDetail();
        category = post.getCategory();
        price = post.getPrice();
        hasPromo = false;
        discount = 0.0;
        isAValidPost();
    }

    public Post(PromoPostRequestDTO post) {
        userId = post.getUserId();
        date = LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        detail = post.getDetail();
        category = post.getCategory();
        price = post.getPrice() - (post.getPrice() * post.getDiscount());
        hasPromo = true;
        discount = post.getDiscount();
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
                this.price == null      ||
                this.discount < 0){
            throw new InvalidPostException("El post contiene campos incompletos o erróneos.");
        }
    }
}
