package sprint1.socialmeli.repository;

import org.springframework.stereotype.Repository;
import sprint1.socialmeli.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> postList;

    public PostRepository() {
        this.postList = new ArrayList<>();
    }

    @Override
    public void save(Post post) {
        this.postList.add(post);
    }

    @Override
    public List<Post> getListOfPostOfUser(int followedIDToSearch) {
        return postList
                .stream()
                .filter((Post p) -> p.hasUserID(followedIDToSearch))
                .collect(Collectors.toList());
    }
}
