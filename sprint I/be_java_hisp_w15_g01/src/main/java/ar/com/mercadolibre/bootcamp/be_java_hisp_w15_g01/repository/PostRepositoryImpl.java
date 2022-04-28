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

    private final List<Post> posts = new ArrayList<>();

    @Override
    public Post create(User user, LocalDate date, Product detail, Integer category, Float price, Float discount, Boolean hasPromo) {

        Post post = new Post();
        post.setPostId(posts.size() +1L);
        post.setUser(user);
        post.setDate(date);
        post.setDetail(detail);
        post.setCategory(category);
        post.setPrice(price);
        post.setDiscount(discount);
        post.setHasPromo(hasPromo);

        posts.add(post);

        return post;
    }
    
    @Override
    public boolean isseller(User user) {
        return this.posts.stream().anyMatch(p -> p.getUser().equals(user));
    }

    @Override
    public List<Post> getAllPostsByUserWithinTimespan(User user, Integer daysBack) {
        LocalDate now = LocalDate.now();

        List<Post> postList = posts.stream()
                .filter( p -> p.getUser().getUserId().equals(user.getUserId()) &&
                        (daysBack == null || p.getDate().compareTo(now.minusDays(daysBack)) > 0) )
                .collect(Collectors.toList());

        return postList;
    }

}
