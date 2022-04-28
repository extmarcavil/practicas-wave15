package sprint1.socialmeli.utils;

import org.springframework.stereotype.Component;
import sprint1.socialmeli.dto.ResponsePostDTO;
import sprint1.socialmeli.dto.RequestPromoPostDTO;
import sprint1.socialmeli.dto.ResponsePromoPostDTO;
import sprint1.socialmeli.model.Post;

@Component
public class PostConverter extends Converter<ResponsePostDTO,Post> {

    public PostConverter() {
        super(PostConverter::convertToEntity, PostConverter::convertToDto);
    }

    private static ResponsePostDTO convertToDto(Post post) {
        return new ResponsePostDTO(post);
    }



    private static Post convertToEntity(ResponsePostDTO dto) {
        throw new RuntimeException("Conversion no implementada");
    }
    private static Post convertToEntity(RequestPromoPostDTO dto) {
        throw new RuntimeException("Conversion no implementada");
    }
}