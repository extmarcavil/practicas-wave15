package sprint1.socialmeli.utils;

import org.springframework.stereotype.Component;
import sprint1.socialmeli.dto.post.response.ResponsePromoPostDTO;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.PromoPost;

@Component
public class PromoPostConverter extends Converter<ResponsePromoPostDTO, Post> {

    public PromoPostConverter() {
        super(PromoPostConverter::convertToEntity, PromoPostConverter::convertToDto);
    }

    private static ResponsePromoPostDTO convertToDto(Post post) {
        return new ResponsePromoPostDTO((PromoPost) post);
    }

    private static Post convertToEntity(ResponsePromoPostDTO dto) {
        throw new RuntimeException("Conversion no implementada");
    }
}