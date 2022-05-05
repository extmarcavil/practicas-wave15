package Utils;

import com.sprint1.be_java_hisp_w15_g4.model.Post;
import com.sprint1.be_java_hisp_w15_g4.model.Product;
import com.sprint1.be_java_hisp_w15_g4.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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



}
