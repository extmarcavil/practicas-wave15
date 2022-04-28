package sprint1.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.dto.RequestPostDTO;
import sprint1.socialmeli.dto.RequestPromoPostDTO;
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
    private Boolean hasPromo;
    private Double discount;


    public Post(RequestPostDTO post) {
        userId = post.getUserId();
        date = LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        detail = post.getDetail();
        category = post.getCategory();
        price = post.getPrice();
        hasPromo = false;
        discount = 0.0;
        isAValidPost();
    }
    public Post(RequestPromoPostDTO post){
        userId = post.getUserId();
        date = LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        detail = post.getDetail();
        category = post.getCategory();
        price = post.getPrice();
        hasPromo = post.getHasPromo();
        discount = post.getDiscount();
        isAValidPromoPost();
        applyDiscount();
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

    private void isAValidPromoPost(){
        isAValidPost();
        if(     this.hasPromo == null ||
                this.discount == null   ){
            throw new InvalidPostException("El promo post contiene campos incompletos.");
        }
    }

    private void applyDiscount() {
        if(this.discount <= 0.0){
            throw new InvalidPostException("El descuento no es válido.");
        }
        this.price = this.price - (this.price * this.discount);
        System.out.println(this.price);
    }
}
