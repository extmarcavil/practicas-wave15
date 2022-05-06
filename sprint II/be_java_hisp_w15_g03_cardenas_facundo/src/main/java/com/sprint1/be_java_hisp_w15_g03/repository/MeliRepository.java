package com.sprint1.be_java_hisp_w15_g03.repository;

import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MeliRepository implements IMeliRepository {

    private final static HashMap<Integer, User> users;
    private final static HashMap<Integer, Seller> sellers;
    private final static HashMap<Integer, Product> products;

    private final static HashMap<Integer, User> usersData = new HashMap<>();
    private final static HashMap<Integer, Seller> sellersData = new HashMap<>();
    private final static HashMap<Integer, Product> productsData = new HashMap<>();
    private static int cantPublicacion;
    static {
        users = new HashMap<>();
        users.put(1, new User(1, "Pepe"));
        users.put(2, new User(2, "Jose"));

        sellers = new HashMap<>();
        sellers.put(1, new Seller(1, "Mercado Libre"));
        sellers.put(2, new Seller(2, "Amazon"));
        products = new HashMap<>();
        cantPublicacion = 0;
    }
    @Override
    public void followSeller(Integer userId, Integer userToFollow) {
        User user = users.get(userId);
        Seller seller = sellers.get(userToFollow);

        List<Seller> sellerList = user.getFollowed();
        sellerList.add(seller);

        List<User> userList = seller.getFollowers();
        userList.add(user);
    }

    @Override
    public Seller getSeller(Integer id) {
        return sellers.get(id);
    }

    @Override
    public User getUser(Integer id) {
        return users.get(id);
    }


    public Boolean hasUser(Integer userId) {
        return users.containsKey(userId);
    }

    public Boolean hasSeller(Integer userToFollow) {
        return users.containsKey(userToFollow);
    }

    /**
     * Método creado para identificar si un usuario ya sigue a un vendedor o si un vendedor es seguido por un usuario.
     * @param userId Id que identifica al usuario.
     * @param sellerToUnfollow id que identifica al vendedor.
     * @return Boolean
     */
    @Override
    public Boolean following(Integer userId, Integer sellerToUnfollow) {
        User user = getUser(userId);
        Seller seller = getSeller(sellerToUnfollow);
       return user.getFollowed().contains(seller) && seller.getFollowers().contains(user);
    }

    @Override
    public void unFollowSeller(Integer userId, Integer sellerToUnfollow) {
        User user = users.get(userId);
        Seller seller = sellers.get(sellerToUnfollow);

        List<Seller> sellerList = user.getFollowed();
        sellerList.remove(seller);

        List<User> userList = seller.getFollowers();
        userList.remove(user);
    }

    @Override
    public void savePublication(Integer userId, Publication p) {
        cantPublicacion+=1;
        p.setPostId(cantPublicacion);
        sellers.get(userId).getPublications().add(p);

    }

    @Override
    public Boolean hasProduct(Integer product) {
        return products.containsKey(product);
    }

    @Override
    public List<Publication> getLastPublications(int userId){

        List<Seller> sellers1 = users.get(userId).getFollowed();
        List<Publication> publications = new ArrayList<>();

        sellers1.forEach( s -> publications.addAll(s.getPublications()));

        /*
          Variable creada para obtener la fecha de dos semanas antes
           a partir del dia de hoy(LocalDate.now())
         */
        LocalDate twoWeeks = LocalDate.now().minus(2, ChronoUnit.WEEKS);

        return publications.stream().filter( p ->  p.getDate().isAfter(twoWeeks) ).collect(Collectors.toList());
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getProductId(),product);
    }

    @Override
    public Product getProduct(int productId){
        return products.get(productId);
    }

    public User addUser(User user){
        user.setUserId(users.size() + 1);
        users.put(user.getUserId(), user);
        return user;
    }

    public Seller addSeller(Seller seller){
        seller.setUserId(sellers.size() + 1);
        sellers.put(seller.getUserId(), seller);
        return seller;
    }
}
