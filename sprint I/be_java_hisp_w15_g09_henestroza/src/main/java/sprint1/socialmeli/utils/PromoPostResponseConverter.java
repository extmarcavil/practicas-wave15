package sprint1.socialmeli.utils;

import sprint1.socialmeli.dtos.PromoPostResponseDTO;
import sprint1.socialmeli.model.Post;

public class PromoPostResponseConverter extends Converter<PromoPostResponseDTO, Post> {
    public PromoPostResponseConverter() {
        super(PromoPostResponseConverter::convertToEntity, PromoPostResponseConverter::convertToDto);
    }
    private static PromoPostResponseDTO convertToDto(Post post) {
        PromoPostResponseDTO promoPost = new PromoPostResponseDTO();
        promoPost.setPostId(post.getPostId());
        promoPost.setDate(post.getDate());
        promoPost.setDetail(post.getDetail());
        promoPost.setCategory(post.getCategory());
        promoPost.setPrice(post.getPrice());
        promoPost.setHasPromo(post.getHasPromo());
        promoPost.setDiscount(post.getDiscount());
        return promoPost;
    }

    private static Post convertToEntity(PromoPostResponseDTO dto) {
        throw new RuntimeException("Unimplemented method");

    }
}
