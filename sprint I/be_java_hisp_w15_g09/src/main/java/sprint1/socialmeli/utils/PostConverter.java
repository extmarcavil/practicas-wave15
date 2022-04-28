package sprint1.socialmeli.utils;

import sprint1.socialmeli.dto.post.response.ResponsePostDTO;
import sprint1.socialmeli.model.Post;

//@Component
public class PostConverter extends Converter<ResponsePostDTO,Post> {

    public PostConverter() {
        super(PostConverter::convertToEntity, PostConverter::convertToDto);
    }

    private static ResponsePostDTO convertToDto(Post post) {
        return ResponsePostDTO.createPostDTO(post);
    }

    private static Post convertToEntity(ResponsePostDTO dto) {
        throw new RuntimeException("Conversion no implementada");
    }
}