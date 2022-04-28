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
    public Post createPost(User user, LocalDate date, Product detail, Integer category, Float price, Boolean promo, Float discount) {

        Post post = new Post();
        post.setPostId(posts.size() +1L);
        post.setUser(user);
        post.setDate(date);
        post.setDetail(detail);
        post.setCategory(category);
        post.setPrice(price);

        if(promo != null && discount != null){
        post.setHasPromo(promo);
        post.setDiscount(discount);
        }
        else{
            post.setHasPromo(false);
            post.setDiscount(0F);
        }

        posts.add(post);

        return post;
    }

    @Override
    public boolean isSeller(User user) {
        return this.posts.stream().anyMatch(p -> p.getUser().equals(user));
    }

    @Override
    public List<Post> getAllPostsByUserWithinTimeStamp(User user, int daysBack) {
        LocalDate now = LocalDate.now();

        List<Post> postList = posts.stream()
                .filter( p -> p.getUser().getUserId().equals(user.getUserId()) &&
                        p.getDate().compareTo(now.minusDays(daysBack)) > 0)
                .collect(Collectors.toList());

        return postList;
    }

    @Override
    public Integer howManyPromoPostById(Long id) {

        return (int) posts.stream()
                .filter(p -> p.getUser().getUserId().equals(id) && p.getHasPromo())
                .count();
    }


}
