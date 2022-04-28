package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.PostPromo;
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
    List<PostPromo> postsPromo = new ArrayList<>();

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

    public PostPromo createPostPromo(User user, LocalDate date, Product detail, Integer category, Float price, boolean hasPromo, double discount) {

        PostPromo postPromo = new PostPromo();
        postPromo.setPostId(posts.size() +1L);
        postPromo.setUser(user);
        postPromo.setDate(date);
        postPromo.setDetail(detail);
        postPromo.setCategory(category);
        postPromo.setPrice(price);
        if (hasPromo){
            postPromo.setHasPromo(hasPromo);
            postPromo.setDiscount(discount);
        }
        postsPromo.add(postPromo);
        return postPromo;
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
    public List<PostPromo> getAllPromoPostsByID(Long id) {
        return postsPromo
                .stream()
                .filter(p ->p.getUser().getUserId().equals(id))
                .collect(Collectors.toList());
    }


}
