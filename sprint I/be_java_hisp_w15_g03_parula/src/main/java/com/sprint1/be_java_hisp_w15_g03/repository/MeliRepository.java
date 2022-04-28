package com.sprint1.be_java_hisp_w15_g03.repository;

import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
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

    /**
     * Se realiza
     * Para el vendedor: el almacenamiento en la tabla de seguidoores al usuario
     * Para el usuario: el almacenamiento en la tabla de seguidos al vendedor
     * @param userId id del usuario
     * @param userToFollow id del vendedor
     */
    @Override
    public void followSeller(Integer userId, Integer userToFollow) {
        User user = users.get(userId);
        Seller seller = sellers.get(userToFollow);

        List<Seller> sellerList = user.getFollowed();
        sellerList.add(seller);

        List<User> userList = seller.getFollowers();
        userList.add(user);
    }

    /**
     * Se requiere el envio de un vendedor particular
     * @param id id del vendedor
     * @return devuelve el vendedor buscado
     */
    @Override
    public Seller getSeller(Integer id) {
        return sellers.get(id);
    }

    /**
     * Se requiere el envio de un usuario particular
     * @param id id del usuario
     * @return devuelve el usuario
     */
    @Override
    public User getUser(Integer id) {
        return users.get(id);
    }


    /**
     * Se requiere saber si un usuario existe
     * @param userId id del usuario que se desea consultar
     * @return
     */
    public Boolean hasUser(Integer userId) {
        return users.containsKey(userId);
    }

    /**
     * Se requiere saber si un vendedor existe
     * @param id id del vendedor a consultar
     * @return
     */
    public Boolean hasSeller(Integer id) {
        return users.containsKey(id);
    }

    /**
     * se requiere saber si ya tienen relacion
     * (si el usuario esta siguiendo al vendedor y el vendedor tiene en la lista de quien lo sigue al usuario).
     * El chequeo multiple se hace para mantener consistencia de datos
     * @param userId
     * @param sellerToUnfollow
     * @return
     */
    @Override
    public Boolean following(Integer userId, Integer sellerToUnfollow) {
        User user = getUser(userId);
        Seller seller = getSeller(sellerToUnfollow);
       return user.getFollowed().contains(seller) && seller.getFollowers().contains(user);
    }

    /**
     *Se borran las asociaciones:
     * Usuario: no tiene mas en lista de seguidos a vendedor
     * Vendedor: no tiene mas en lista de seguidores a usuario
     * @param userId
     * @param sellerToUnfollow
     */
    @Override
    public void unFollowSeller(Integer userId, Integer sellerToUnfollow) {
        User user = users.get(userId);
        Seller seller = sellers.get(sellerToUnfollow);

        List<Seller> sellerList = user.getFollowed();
        sellerList.remove(seller);

        List<User> userList = seller.getFollowers();
        userList.remove(user);
    }

    /**
     * Almacena una publicacion a un vendedor
     * @param userId id del vendedor
     * @param p publicacion
     */
    @Override
    public void savePublication(Integer userId, Publication p) {
        cantPublicacion+=1;
        p.setPostId(cantPublicacion);
        sellers.get(userId).getPublications().add(p);

    }

    /**
     * Devuelve si existe determinado producto
     * @param product id del producto a consultar
     * @return devuelve si existe
     */
    @Override
    public Boolean hasProduct(Integer product) {
        return products.containsKey(product);
    }

    /**
     * Devuelve una lista de las publicaciones de los seguidores de un usuario en las ultimas 2 semanas
     * @param userId id del usuario que quiero publicaciones de sus vendedores seguidos
     * @return devuelve la lista de vendedores filtrada segun lo requerido
     */
    @Override
    public List<Publication> getLastPublications(int userId){

        List<Seller> sellers1 = users.get(userId).getFollowed();
        List<Publication> publications = new ArrayList<>();

        sellers1.forEach( s -> publications.addAll(s.getPublications()));
        LocalDate twoWeeks = LocalDate.now().minus(2, ChronoUnit.WEEKS);

        return publications.stream().filter( p ->  p.getDate().isAfter(twoWeeks) ).collect(Collectors.toList());
    }

    /**
     * Devuelve las publicaciones en promo de un vendedor
     * @param sellerId vendedor que quiero ver las promos
     * @return lista de publicaciones que estan en promocion
     */
    @Override
    public List<Publication> getPromoProduct(int sellerId){
        Seller seller = sellers.get(sellerId);
        List<Publication> promoPublications = seller.getPublications().stream()
                                            .filter(p -> p.getHasPromo())
                                            .collect(Collectors.toList());
        return promoPublications;

    }

    /**Devuelve todos los vendedores**/
    @Override
    public List<Seller> getSellers(){
        return new ArrayList<Seller>(sellers.values());
    }

    /**
     * Agrega un producto a la coleccion de productos
     * @param product el producto a agregar
     */
    @Override
    public void addProduct(Product product) {
        products.put(product.getProductId(),product);
    }

    /**
     * Obtiene un producto de la coleccion
     * @param productId id del producto pedido
     * @return del producto
     */
    @Override
    public Product getProduct(int productId){
        return products.get(productId);
    }
}
