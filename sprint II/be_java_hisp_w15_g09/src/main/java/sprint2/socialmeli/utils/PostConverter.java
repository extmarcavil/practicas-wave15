package sprint2.socialmeli.utils;

import sprint2.socialmeli.dto.post.response.ResponsePostDTO;
import sprint2.socialmeli.model.Post;

//@Component
public class PostConverter extends Converter<ResponsePostDTO, Post> {

    public PostConverter() {
        super(PostConverter::convertToEntity, PostConverter::convertToDto);
    }

    private static ResponsePostDTO convertToDto(Post post) {
        return new ResponsePostDTO(post);
    }

    private static Post convertToEntity(ResponsePostDTO dto) {
        throw new RuntimeException("Conversion no implementada");
    }
}