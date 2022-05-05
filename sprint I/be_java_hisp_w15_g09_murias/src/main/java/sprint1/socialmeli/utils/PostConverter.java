package sprint1.socialmeli.utils;

import org.springframework.stereotype.Component;
import sprint1.socialmeli.dto.PostResponseDTO;
import sprint1.socialmeli.dto.PromoPostResponseDTO;
import sprint1.socialmeli.model.Post;

@Component
public class PostConverter extends Converter<PostResponseDTO,Post> {

    public PostConverter() {
        super(PostConverter::convertToEntity, PostConverter::convertToDto);
    }

    private static PostResponseDTO convertToDto(Post post) {
        if (post.isHasPromo() == false)
            return new PostResponseDTO(post);
        else
            return new PromoPostResponseDTO(post);
    }

    private static Post convertToEntity(PostResponseDTO dto) {
        throw new RuntimeException("Conversion no implementada");
    }
}