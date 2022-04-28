package sprint1.socialmeli.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.PostPromo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Repository
public class PostRepository implements IPostRepository {

    private final Map<Integer, Post> postList;
    private final Map<Integer, PostPromo> postPromoList;
    private Integer postId;

    public PostRepository() {
        this.postList = new HashMap<>();
        this.postPromoList = new HashMap<>();
        postId = 0;
    }

    @Override
    public Integer save(Post post) {
        this.postList.put(++postId, post);
        post.setPostId(postId);
        return postId;
    }
    @Override
    public Integer savePromo(PostPromo post) {
        this.postPromoList.put(++postId, post);
        post.setPostId(postId);
        return postId;
    }

    @Override
    public List<Post> getListOfPostOfUser(int followedIDToSearch) {
        return postList.values()
                .stream()
                .filter((Post p) -> p.hasUserID(followedIDToSearch))
                .collect(Collectors.toList());
    }
}
