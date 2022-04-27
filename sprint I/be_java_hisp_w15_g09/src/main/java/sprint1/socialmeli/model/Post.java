package sprint1.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.dto.PostResponseDTO;

import java.time.LocalDate;

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
    }

    public boolean hasUserID(int IDToMatch) {
        return userId.equals(IDToMatch);
    }
}
