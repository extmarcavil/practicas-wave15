package sprint1.socialmeli.model;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.dto.post.request.RequestPromoPostDTO;

@Getter
@Setter
public class PromoPost extends Post {

    boolean hasPromo;
    float discount;

    public PromoPost(RequestPromoPostDTO postDTO) {
        super(postDTO);
        hasPromo = true;
        discount = postDTO.getDiscount();
    }

    @Override
    public boolean isAPromoPost() {
        return true;
    }

    public float getDiscount() {
        return discount;
    }
}
