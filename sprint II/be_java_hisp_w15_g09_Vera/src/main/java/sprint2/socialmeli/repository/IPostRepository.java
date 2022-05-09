package sprint2.socialmeli.repository;

import sprint2.socialmeli.model.Post;

import java.util.List;

public interface IPostRepository {
    Integer save(Post post);
    List<Post> getListOfPostOfUser(int followedIDToSearch);
}
