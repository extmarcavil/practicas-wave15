package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.DiscountedPostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.*;
import com.bootcamp.be_java_hisp_w15_g02.exception.NotSellerException;
import com.bootcamp.be_java_hisp_w15_g02.exception.OrderNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import com.bootcamp.be_java_hisp_w15_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{

    private IPostRepository postRepository;
    private IUserRepository userRepository;

    /**
     * <p>
     * Constructor del service. Trae la inyección del repositorio post y repositorio usuario.
     * </p>
     * @param postRepository Repositorio de Post.
     * @param userRepository Repositorio de Usuario.
     */
    public PostService(IPostRepository postRepository, IUserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    /**
     * Crea un post y lo guarda en la lista de posts.
     * <p>
     * El método recibe un PostCreateDTO, luego crea una variable local para obtener la fecha actual.
     * Luego se convierte el PostCreateDTO en un objeto tipo Post, para guardar en la lista de posts.
     * <p>
     * @param newPost La información del post.
     * @return Retorna un booleano dependiendo de la respuesta del guardado.
     */
    @Override
    public boolean createPost(PostCreateDTO newPost) {
        var id = 0;
        var user = userRepository.getUserById(newPost.getUser_id());
        user.setSeller(true);
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
        postRepository.createPost(modelPost);
        return true;
    }

    /**
     * Crate a discounted post and save in the repository's list
     * <p>
     * The method receives a post with the discount data
     * @param newPost The DTO data of post
     * @return Returns a boolean to confirm the registration
     */
    @Override
    public boolean createPost(DiscountedPostCreateDTO newPost) {
        var user = userRepository.getUserById(newPost.getUserId());
        user.setSeller(true);
        var postList = postRepository.all();
        var id = postList.size() == 0 ? 1 : postList.size() + 1;
        var modelProduct = new Product(newPost.getDetail().getProduct_id(), newPost.getDetail().getProduct_name(),
                                       newPost.getDetail().getType(), newPost.getDetail().getBrand(),
                                       newPost.getDetail().getColor(),newPost.getDetail().getNotes());
        var modelPost = new Post(id, newPost.getUserId(), newPost.getDate(), newPost.getCategory(), modelProduct,
                                 newPost.getPrice(), newPost.getDiscount());
        postRepository.createPost(modelPost);
        return true;
    }

    /**
     * Obtiene la lista de posts de los vendedores que sigue un usuario.
     * <p>
     * El método recibe el id de un usuario y opcionalmente el orden de los datos. Llama a la lista de seguidos del usuario con
     * el parametro id, y con esa lista de seguidos, busca sus posts en la lista de posts filtrados dos semanas antes de la
     * fecha actual.
     * <p>
     * @param idUser Id del usuario.
     * @param order Orden de los datos.
     * @return Retorna el id del usuario con las publicaciones de los vendedores que sigue.
     */
    @Override
    public GetPostsSellerByUserIdDTO getListPostByFollowIdUser(int idUser, String order){

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

        if (order != null) {
            if (order.equals("date_asc"))
                response.getPosts().sort(Comparator.comparing(PostsBySellersDTO::getDate));
            else if (order.equals("date_desc"))
                response.getPosts().sort(Comparator.comparing(PostsBySellersDTO::getDate, Comparator.reverseOrder()));
            else
                throw new OrderNotFoundException("Orden no encontrado");
        }
        return new GetPostsSellerByUserIdDTO(idUser,posts);
    }

    /**
     * Returns the quantity of discounted products from a seller
     * @param userId Seller id
     * @return Quantity of discounted products
     */
    @Override
    public DiscountedProductsBySellerDTO getCountDiscountedProducts(int userId) {
        var user = userRepository.getUserById(userId);
        var numPosts = postRepository.getDiscountedProducts(userId).size();
        DiscountedProductsBySellerDTO discountedProducts;
        if (user.isSeller()) {
            discountedProducts = new DiscountedProductsBySellerDTO(userId, user.getUserName(), numPosts);
        } else {
            throw new NotSellerException("Usuario no vendedor");
        }
        return discountedProducts;
    }

    /**
     * Returns Returns a list with publications with discounted products
     * @param userId Seller id
     * @return DTO with user data and list of with publications with discounted products
     */
    @Override
    public DiscountedProductsListDTO findDiscountedProductsBySeller(int userId) {
        var user = userRepository.getUserById(userId);
        var posts = postRepository.getDiscountedProducts(userId);
        var postsDto = posts.stream().map(p -> {
            PostDTO postDTO = new PostDTO(p.getPostId(), p.getDate(), p.getDetail(), p.getCategory(), p.getPrice(),
                                          p.isHasPromo(), p.getDiscount());
            return postDTO;
        }).collect(Collectors.toList());
        return new DiscountedProductsListDTO(userId, user.getUserName(), postsDto);
    }
}
