package Utils;

import com.sprint1.be_java_hisp_w15_g4.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.model.Post;
import com.sprint1.be_java_hisp_w15_g4.model.Product;
import com.sprint1.be_java_hisp_w15_g4.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestGenerator {


    public static User GenerateUser(int userId, String name) {

        return new User(userId, name);
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

    public static PostDTO GeneratePostsDTO(int userId, String date) {

        PostDTO post = new PostDTO();

        post.setUser_id(userId);
        post.setDate(LocalDate.parse(date));
        post.setCategory(1);
        post.setPrice(100.0);
        post.setDetail(new ProductDTO());

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
