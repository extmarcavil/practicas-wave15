package sprint1.socialmeli.repository;

import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.PostPromo;

import java.util.List;

public interface IPostRepository {
    Integer save(Post post);
    List<Post> getListOfPostOfUser(int followedIDToSearch);
    Integer countPromoPostOfUser(int followedIDToSearch);
}
