package com.bootcamp.be_java_hisp_w15_g02.service;

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
import java.util.Date;
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
        var postlist = postRepository.all();
        id = postlist.size() == 0 ? 1 : postlist.size() + 1;
        var modelProduct = new Product();
        var instant = newPost.getDate().toInstant();
        var zdt = instant.atZone(ZoneId.systemDefault());
        var date = zdt.toLocalDate();
        modelProduct.setProductId(newPost.getDetail().getProduct_id());
        modelProduct.setProductName(newPost.getDetail().getProduct_name());
        modelProduct.setType(newPost.getDetail().getType());
        modelProduct.setBrand(newPost.getDetail().getBrand());
        modelProduct.setColor(newPost.getDetail().getColor());
        modelProduct.setNotes(newPost.getDetail().getNotes());
        var modelPost = new Post(
                id, newPost.getUser_id(), date, Integer.valueOf(newPost.getCategory()), modelProduct, newPost.getPrice(),newPost.isHas_promo(),newPost.getDiscount());
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
     * obtiene el numero de productos que tienen promocion un determinado usuario.
     * <p>
     * El método recibe un userId, filtra los post del user y tambien que tengan promocion.
     * <p>
     * @param userId identificador del usuario.
     * @return Retorna un GetProductsCountPromoByUserDTO.
     */

    @Override
    public GetProductsCountPromoByUserDTO getProductsCountPromoByUser(int userId) {
        var result = new GetProductsCountPromoByUserDTO();
        var whereUser = userRepository.getUserById(userId);
        if(!whereUser.isSeller())
            throw new NotSellerException("Este usuario no es vendedor");

        var listPostByUser = postRepository.postsByUser(userId);
        result.setPromo_products_count((int)listPostByUser.stream().filter(f -> f.isHasPromo()).count());
        result.setUser_id(whereUser.getUserId());
        result.setUser_name(whereUser.getUserName());

        return result;
    }

    /**
     * obtiene la lista  de productos que tienen promocion.
     * <p>
     * El método recibe un userId, filtra los post del user y tambien que tengan promocion.
     * <p>
     * @param userId identificador del usuario.
     * @return Retorna un GetProductsPromoByUserDTO.
     */
    @Override
    public GetProductsPromoByUserDTO getProductsPromoByUser(int userId) {
        var result = new GetProductsPromoByUserDTO();
        var whereUser = userRepository.getUserById(userId);
        if(!whereUser.isSeller())
            throw new NotSellerException("Este usuario no es vendedor");

        var listPostByUser = postRepository.postsByUser(userId)
                .stream()
                .filter(f -> f.isHasPromo()).collect(Collectors.toList());

        var listPost = new ArrayList<PostDTO>();

        listPostByUser.forEach(item ->{
            var postDTO = new PostDTO();
            var productModel = item.getDetail();
            var productDTO = new ProductDTO();
            productDTO.setProduct_id(productModel.getProductId());
            productDTO.setProduct_name(productModel.getProductName());
            productDTO.setType(productModel.getType());
            productDTO.setBrand(productModel.getBrand());
            productDTO.setColor(productModel.getColor());
            productDTO.setNotes(productModel.getNotes());

            postDTO.setPost_id(item.getPostId());
            postDTO.setDate(item.getDate());
            postDTO.setDetail(productDTO);
            postDTO.setCategory(item.getCategory());
            postDTO.setPrice(item.getPrice());
            postDTO.setHas_promo(item.isHasPromo());
            postDTO.setDiscount(item.getDiscount());

            listPost.add(postDTO);
        });
        result.setUser_id(whereUser.getUserId());
        result.setUser_name(whereUser.getUserName());
        result.setPosts((List)listPost);
        return result;
    }
}
