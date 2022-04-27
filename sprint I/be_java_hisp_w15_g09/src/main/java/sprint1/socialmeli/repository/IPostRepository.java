package sprint1.socialmeli.repository;

import sprint1.socialmeli.model.Post;

import java.util.List;

public interface IPostRepository {
    Integer save(Post post);
    List<Post> getListOfPostOfUser(int followedIDToSearch);
}
