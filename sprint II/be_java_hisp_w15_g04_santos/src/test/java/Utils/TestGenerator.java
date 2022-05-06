package Utils;

import com.sprint2.be_java_hisp_w15_g4.dto.ProductDTO;
import com.sprint2.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint2.be_java_hisp_w15_g4.model.Post;
import com.sprint2.be_java_hisp_w15_g4.model.Product;
import com.sprint2.be_java_hisp_w15_g4.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestGenerator {


    public static User GenerateUser(int userId, String name) {

        return new User(userId, name);
    }

    public static User GenerateUserWPost(int userId, String name) {

        User user = new User(userId, name);
        Post post1 = GeneratePosts(userId, "2022-04-27");
        Post post2 = GeneratePosts(userId, "2022-05-02");

        user.setUser_id(userId);
        user.setUser_name(name);
        user.setPosts(List.of(post1, post2));

        return user;
    }

    public static PostDTO GeneratePostDTO(String date) {

        PostDTO postDTO = new PostDTO();
        ProductDTO productDTO = GenerateProductDTO();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        postDTO.setUser_id(1);
        postDTO.setCategory(1);
        postDTO.setDate(LocalDate.parse(date, formatter));
        postDTO.setPrice(100.0);
        postDTO.setDetail(productDTO);

        return postDTO;
    }

    public static ProductDTO GenerateProductDTO() {

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProduct_id(1);
        productDTO.setProduct_name("Mobile Phone");
        productDTO.setBrand("Samsung");
        productDTO.setColor("Red");
        productDTO.setType("Technology");
        productDTO.setNotes("Fastest phone on earth");

        return productDTO;
    }

    public static Post GeneratePosts(int userId, String date) {

        Post post = new Post();

        post.setUser_id(userId);
        post.setDate(LocalDate.parse(date));
        post.setCategory(1);
        post.setPrice(100.0);
        post.setDetail(new Product());

        return post;
    }

    public static User userWithFollowings (){
        User user = new User(1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "lombre2");
        User user4 = new User(4, "aombre2");

        user.setFollowing(List.of(
                user2,
                user3,
                user4
        ));
        return user;
    }

    public static User userWithFollowers (){
        User user = new User(1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "lombre2");
        User user4 = new User(4, "aombre2");

        user.setFollowers(List.of(
                user2,
                user3,
                user4
        ));
        return user;
    }



}
