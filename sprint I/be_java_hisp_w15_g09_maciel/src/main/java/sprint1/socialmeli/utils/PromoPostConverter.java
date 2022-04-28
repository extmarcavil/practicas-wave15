package sprint1.socialmeli.utils;

import org.springframework.stereotype.Component;
import sprint1.socialmeli.dto.ResponsePostDTO;
import sprint1.socialmeli.dto.ResponsePromoPostDTO;
import sprint1.socialmeli.model.Post;

@Component
public class PromoPostConverter extends Converter<ResponsePromoPostDTO, Post>{
    public PromoPostConverter() {
        super(PromoPostConverter::convertToEntity, PromoPostConverter::convertToDto);
    }

    private static ResponsePromoPostDTO convertToDto(Post post) {
        return new ResponsePromoPostDTO(post);
    }

    private static Post convertToEntity(ResponsePromoPostDTO dto) {
        throw new RuntimeException("Conversion no implementada");
    }


}
