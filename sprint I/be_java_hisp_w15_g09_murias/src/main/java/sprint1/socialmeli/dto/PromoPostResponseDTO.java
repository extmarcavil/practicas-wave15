package sprint1.socialmeli.dto;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Post;

@Getter
@Setter
public class PromoPostResponseDTO extends PostResponseDTO{
    private boolean hasPromo;
    private Double discount;

    public PromoPostResponseDTO(Post post) {
        super(post);
        this.hasPromo = post.isHasPromo();
        this.discount = post.getDiscount();
    }
}
