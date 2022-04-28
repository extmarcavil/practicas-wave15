package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.AlreadyFollowerExcepcion;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.SameIdException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements PostRepository {

    List<Post> posts = new ArrayList<>();
    List<Cart> cartList = new ArrayList<>();

    @Override
    public Post create(User user, LocalDate date, Product detail, Integer category, Float price, Boolean hasPromo, Double discount) {
        Optional<Post> pos = posts.stream().filter(x->x.getDetail().getProductId().equals(detail.getProductId())).findAny();

        if(pos.isPresent()){
            throw new SameIdException("The product with that ID already exists");
        }
        Post post = new Post();
        if(hasPromo != null && discount != null) {
            post.setPostId(posts.size() + 1L);
            post.setUser(user);
            post.setDate(date);
            post.setDetail(detail);
            post.setCategory(category);
            post.setPrice(price);
            post.setHasPromo(hasPromo);
            post.setDiscount(discount);
            posts.add(post);
            return post;
        }else {
            post.setPostId(posts.size() + 1L);
            post.setUser(user);
            post.setDate(date);
            post.setDetail(detail);
            post.setCategory(category);
            post.setPrice(price);
            posts.add(post);
            return post;
        }
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
    public List<Post> getListOfPromoPosts(Long id){
        return posts.stream().
                filter(x->x.getHasPromo() != null && x.getDiscount() != null && x.getUser().getUserId().equals(id) && x.getHasPromo().equals(true))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return posts.stream().filter(x-> x.getDetail().getProductId()
        .equals(id)).map(x->x.getDetail()).findFirst();
    }


    @Override
    public Boolean existByUserAndProduct(Product product, User user) {
        return cartList.stream().anyMatch(x->x.getProduct().getProductId().equals(product.getProductId()) && x.getUser().getUserId().equals(user.getUserId()));
    }

    public Cart addProductToPurchase(User user, Product product){
        Cart newCart = new Cart(user, product);
        Optional<Cart> cart = cartList.stream().filter(x->x.getProduct().getProductId().equals(product.getProductId())).findAny();
        if(existByUserAndProduct(product, user)){
            throw new SameIdException("The product with that ID is already in the shopping Cart");
        }
        cartList.add(newCart);
        return newCart;

    }

    @Override
        public List<Product> getListOfProducts(Long id){
        return cartList.stream()
                .filter(x-> x.getUser().getUserId().equals(id)).map(x->x.getProduct()).collect(Collectors.toList());

    }

}
