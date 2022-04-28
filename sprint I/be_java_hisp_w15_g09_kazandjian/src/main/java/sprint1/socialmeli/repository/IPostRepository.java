package sprint1.socialmeli.repository;

import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.PostPromo;

import java.util.List;

public interface IPostRepository {
    Integer save(Post post);
    Integer savePromo(PostPromo postPromo);
    List<Post> getListOfPostOfUser(int followedIDToSearch);
}
