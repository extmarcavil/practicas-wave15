package com.sprint1.be_java_hisp_w15_g03.repository;

import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;

import java.util.List;

public interface IMeliRepository {
    void followSeller(Integer userId, Integer sellerToFollow);
    Seller getSeller(Integer id);
    User getUser(Integer id);
    void unFollowSeller(Integer userId, Integer sellerToUnfollow);
    Boolean hasUser(Integer id);
    Boolean hasSeller(Integer id);
    Boolean hasProduct(Integer product);
    Boolean following(Integer userId, Integer sellerToUnfollow);
    void savePublication(Integer userId, Publication p);
    List<Publication> getLastPublications(int userId);

    void addProduct(Product product);
    Product getProduct(int productId);
   // void loadData();
}
