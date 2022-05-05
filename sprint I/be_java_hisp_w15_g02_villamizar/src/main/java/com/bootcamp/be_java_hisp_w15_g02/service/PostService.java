package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.PostsBySellersDTO;
import com.bootcamp.be_java_hisp_w15_g02.exception.InvalidDiscountException;
import com.bootcamp.be_java_hisp_w15_g02.exception.OrderNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.exception.PostNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import com.bootcamp.be_java_hisp_w15_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService implements IPostService{

    private IPostRepository postRepository;
    private IUserRepository userRepository;

    public PostService(IPostRepository postRepository, IUserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean createPost(PostCreateDTO newPost) {
        var id = 0;
        var postlist = postRepository.all();
        id = postlist.size() == 0 ? 1 : postlist.size() + 1;
        var modelProduct = new Product();
        modelProduct.setProductId(newPost.getDetail().getProduct_id());
        modelProduct.setProductName(newPost.getDetail().getProduct_name());
        modelProduct.setType(newPost.getDetail().getType());
        modelProduct.setBrand(newPost.getDetail().getBrand());
        modelProduct.setColor(newPost.getDetail().getColor());
        modelProduct.setNotes(newPost.getDetail().getNotes());
        var instant = newPost.getDate().toInstant();
        var zdt = instant.atZone(ZoneId.systemDefault());
        var date = zdt.toLocalDate();
        var modelPost = new Post(
                id, newPost.getUser_id(), date, Integer.valueOf(newPost.getCategory()), modelProduct, newPost.getPrice());
        if(newPost.isHas_promo()){
            modelPost.setHasPromo(true);
            modelPost.setDiscount(newPost.getDiscount());
        }
        postRepository.createPost(modelPost);
        this.userRepository.getUserById(newPost.getUser_id()).setSeller(true);
        if(newPost.getDiscount()<0 || newPost.getDiscount()>1)
            throw new InvalidDiscountException("El valor del descuento no es valido");
        return true;
    }

    @Override
    public GetPostsDTO getListPostByFollowIdUser(int idUser, String order){
        User user = this.userRepository.getUserById(idUser);
        List<Follow> followList = user.getFollowList();
        GetPostsDTO response = new GetPostsDTO();
        List<PostsBySellersDTO> posts = new ArrayList<>();
        LocalDate twoWeeksBefore = LocalDate.now().minusWeeks(2);

        for (Follow follow: followList) {
            List<Post> sellerPosts = this.postRepository.postsByUser(follow.getUserToFollow());
            for (Post post: sellerPosts) {

                if (post.getDate().isAfter(twoWeeksBefore)){
                    posts.add(new PostsBySellersDTO(post));
                }
            }
            response.setPosts(posts);
        }

        if (order != null) {
            if (order.equals("date_asc"))
                response.getPosts().sort(Comparator.comparing(PostsBySellersDTO::getDate));
            else if (order.equals("date_desc"))
                response.getPosts().sort(Comparator.comparing(PostsBySellersDTO::getDate, Comparator.reverseOrder()));
            else
                throw new OrderNotFoundException("Orden no encontrado");
        }
        return new GetPostsDTO(idUser,posts);
    }

    @Override
    public GetPostsDTO getListPromoPostByIdUser(int idUser){
        GetPostsDTO response = new GetPostsDTO();
        List<PostsBySellersDTO> posts = new ArrayList<>();
        List<Post> userPosts = this.postRepository.postsByUser(idUser);
        for (Post post: userPosts) {
            if (post.isHasPromo()){
                System.out.println("Promo "+post.getDetail().getProductName());
                posts.add(new PostsBySellersDTO(post));
            }else
                System.out.println("No promo "+post.getDetail().getProductName());
        }
        if(posts.isEmpty()) throw new PostNotFoundException("El usuario no tiene posts con promociones");
        response.setPosts(posts);
        return new GetPostsDTO(idUser,posts);
    }

    @Override
    public GetPostsCountDTO getPromoCountByIdUser(int idUser){
        User user = userRepository.getUserById(idUser);
        List<Post> userPosts = this.postRepository.postsByUser(idUser);
        int countPosts = 0;
        for (Post post: userPosts) {
            if (post.isHasPromo()) {
                countPosts++;
            }
        }
        GetPostsCountDTO response = new GetPostsCountDTO(user.getUserId(),
                user.getUserName(),countPosts);
        return response;
    }
}
