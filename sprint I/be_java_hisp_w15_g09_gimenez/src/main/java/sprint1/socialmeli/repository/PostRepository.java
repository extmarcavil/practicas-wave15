package sprint1.socialmeli.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.PostPromo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Repository
public class PostRepository implements IPostRepository {
    private final Map<Integer, Post> postList;
    private Integer postId;
    private final Map<Integer, Post> postListPromo;
    private Integer postPromoId;

    public PostRepository() {
        this.postList = new HashMap<>();
        this.postListPromo = new HashMap<>();
        postId = 0;
        postPromoId = 0;
    }

    @Override
    public Integer save(Post post) {
        if (!post.getHas_promo()) {
            this.postList.put(++postId, post);
            post.setPostId(postId);
            return postId;
        }
        this.postListPromo.put(++postPromoId, post);
        post.setPostId(postPromoId);
        return postPromoId;
    }

    @Override
    public List<Post> getListOfPostOfUser(int followedIDToSearch) {
        return postList.values()
                .stream()
                .filter((Post p) -> p.hasUserID(followedIDToSearch))
                .collect(Collectors.toList());
    }

    @Override
    public Integer countPromoPostOfUser(int followedIDToSearch) {
        List postPromoOfUser = postListPromo.values()
                .stream()
                .filter((Post p) -> p.hasUserID(followedIDToSearch))
                .collect(Collectors.toList());
        return postPromoOfUser.size();
    }
}
