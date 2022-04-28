package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements PostRepository {

    List<Post> posts = new ArrayList<>();

    @Override
    public Post create(User user, LocalDate date, Product detail, Integer category, Float price) {

        Post post = new Post();
        post.setPostId(posts.size() +1L);
        post.setUser(user);
        post.setDate(date);
        post.setDetail(detail);
        post.setCategory(category);
        post.setPrice(price);

        posts.add(post);

        return post;
    }
    
    @Override
    public boolean isseller(User user) {
        return this.posts.stream().anyMatch(p -> p.getUser().equals(user));
    }

    @Override
    public List<Post> getAllPostsByUserWithinTimespan(User user, int daysBack) {
        LocalDate now = LocalDate.now();

        List<Post> postList = posts.stream()
                .filter( p -> p.getUser().getUserId().equals(user.getUserId()) &&
                        p.getDate().compareTo(now.minusDays(daysBack)) > 0)
                .collect(Collectors.toList());

        return postList;
    }

    @Override
    public List<Post> getUserPromoPosts(Long id) {
        return posts
                .stream()
                .filter(p -> p.isOwnedById(id) && p.getHasPromo())
                .collect(Collectors.toList());
    }

    @Override
    public Integer getUserPromoPostsCount(Long id) {
        return getUserPromoPosts(id).size();
    }

    @Override
    public Post createPostPromo(Post post) {
        Post p = create(post.getUser(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice());
        p.setHasPromo(post.getHasPromo());
        p.setDiscount(post.getDiscount());
        return p;
    }

}
