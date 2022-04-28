package sprint1.socialmeli.model;

import sprint1.socialmeli.dto.post.request.RequestPromoPostDTO;


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
