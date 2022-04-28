package sprint1.socialmeli.model;

import sprint1.socialmeli.dto.post.request.RequestPostDTO;

public class NormalPost extends Post {
    public NormalPost(RequestPostDTO postDTO) {
        super(postDTO);
    }

    @Override
    public boolean isAPromoPost() {
        return false;
    }
}
