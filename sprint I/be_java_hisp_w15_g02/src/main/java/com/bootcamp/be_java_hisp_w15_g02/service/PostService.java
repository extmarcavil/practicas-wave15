package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.PostsBySellersDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import com.bootcamp.be_java_hisp_w15_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
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
        var instant = newPost.getDate().toInstant();
        var zdt = instant.atZone(ZoneId.systemDefault());
        var date = zdt.toLocalDate();
        var modelPost = new Post(
                id, newPost.getUser_id(), date, Integer.valueOf(newPost.getCategory()), modelProduct, newPost.getPrice());
        postRepository.createPost(modelPost);
        return true;
    }

    @Override
    public GetPostsSellerByUserIdDTO getListPostByFollowIdUser(int idUser){
        User user = this.userRepository.getUserById(idUser);
        List<Follow> followList = user.getFollowList();
        GetPostsSellerByUserIdDTO response = new GetPostsSellerByUserIdDTO();
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

        return new GetPostsSellerByUserIdDTO(idUser,posts);
    }
}
