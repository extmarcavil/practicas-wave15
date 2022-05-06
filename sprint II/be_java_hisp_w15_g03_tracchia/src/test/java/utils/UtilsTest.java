package utils;

import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.model.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UtilsTest {

    List<User> users;
    List<Seller> sellers;
    List<Product> products;

    public UtilsTest()
    {
        users = new ArrayList<>();
        sellers = new ArrayList<>();
        products = new ArrayList<>();
    }

   public void createUsers()
   {
       User u1 = new User(3,"Pepe");
       User u2 = new User(4,"Maria");
       User u3 = new User(5,"Jose");
       User u4 = new User(6,"Alguien");

       users.add(u1);
       users.add(u2);
       users.add(u3);
       users.add(u4);

   }

   public void  createSellers ()
   {
        Seller s1 = new Seller(3,"Nike");
        Seller s2 = new Seller(4,"Topper");
        Seller s3 = new Seller(5,"Adidas");
        Product p1 = new Product(1,"Zapatillas","a","a","a","a");
        products.add(p1);
        s3.getPublications().add(new Publication(10, LocalDate.now(), Category.MESA,50.0,p1,false,0.0));
        sellers.add(s1);
        sellers.add(s2);
        sellers.add(s3);
   }

   public void createRelations()
   {
       //El userID 3 sigue al sellerID 3
       users.get(0).getFollowed().add(sellers.get(0));
       sellers.get(0).getFollowers().add(users.get(0));

       //El userID 4 sigue al sellerID 4
       users.get(1).getFollowed().add(sellers.get(1));
       sellers.get(1).getFollowers().add(users.get(1));

       //El userID 6 sigue al sellerID 5
       users.get(3).getFollowed().add(sellers.get(2));
       sellers.get(2).getFollowers().add(users.get(3));

   }
}
