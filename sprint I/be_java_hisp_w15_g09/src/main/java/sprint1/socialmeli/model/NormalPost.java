package sprint1.socialmeli.model;

import sprint1.socialmeli.dto.PostRequestDTO;

public class NormalPost extends Post {
    public NormalPost(PostRequestDTO postDTO) {
        super(postDTO);
    }

    @Override
    public boolean isAPromoPost() {
        return false;
    }
}
