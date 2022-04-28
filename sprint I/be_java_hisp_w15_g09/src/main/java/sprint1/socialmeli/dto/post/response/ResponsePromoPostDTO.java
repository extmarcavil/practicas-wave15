package sprint1.socialmeli.dto.post.response;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.PromoPost;

@Setter
@Getter
public class ResponsePromoPostDTO extends ResponsePostDTO{

    private boolean has_promo;
    private float discount;

    public ResponsePromoPostDTO(PromoPost post) {
        super(post);
        this.has_promo = true;
        this.discount = post.getDiscount();
    }

}
