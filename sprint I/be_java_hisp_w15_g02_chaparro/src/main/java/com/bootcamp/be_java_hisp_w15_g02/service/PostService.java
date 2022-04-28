package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PromoPostDTO;
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
        var modelPost = new Post(
                id, newPost.getUser_id(), date, Integer.valueOf(newPost.getCategory()), modelProduct, newPost.getPrice());
        postRepository.createPost(modelPost);
        return true;
    }

    /**
     * Crea un post con descuento y lo guarda en la lista de posts.
     * <p>
     * El método recibe un objeto tipo Post, luego crea una variable local para obtener la fecha actual
     * para guardar en la lista de posts.
     * <p>
     * @param newPost La información del post.
     * @return Retorna un booleano dependiendo de la respuesta del guardado.
     */
    @Override
    public boolean createPromoPost(PromoPostDTO newPost) {
        var id = 0;
        var postlist = postRepository.all();
        id = postlist.size() == 0 ? 1 : postlist.size() + 1;
        Post post = new Post(id,newPost.getUserId(), newPost.getDate(),newPost.getCategory(),newPost.getDetail(),newPost.getPrice(),newPost.isHasPromo(),newPost.getDiscount());
        postRepository.createPost(post);
        return true;
    }

    /**
     * Trae la cantidad total de post con descuento de un vendedor.
     * <p>
     * El método recibe el id de un vendedor, para luego consultar en el repositorio
     * todos los productos, y los que tienen descuento se agrupan y se da el total de productos con descuento.
     * <p>
     * @param userId La información del post.
     * @return Retorna la cantidad de posts con promoción de un vendedor.
     */
    @Override
    public GetPromoPostCountDTO getPromoPostCount(int userId) {
        List<Post> postsList = postRepository.postsByUser(userId);
        User user = userRepository.getUserById(userId);
        if (user.isSeller() == false)
            throw new NotSellerException("Este usuario no es vendedor");
        GetPromoPostCountDTO response = new GetPromoPostCountDTO(userId,
                user.getUserName(),
                postsList.stream().filter(p -> p.isHasPromo() == true).collect(Collectors.toList()).size());
        return response;
    }

    /**
     * Obtiene la lista de posts de los vendedores que sigue un usuario.
     * <p>
     * El método recibe el id de un usuario y opcionalmente el orden de los datos. Llama a la lista de seguidos del usuario con
     * el parametro id, y con esa lista de seguidos, busca sus posts en la lista de posts filtrados dos semanas antes de la
     * fecha actual.
     * <p>
     * @param idUser Id del usuario.
     * @return Retorna el id del usuario con las publicaciones de los vendedores que sigue.
     */
    @Override
    public GetPromoPostBySellerDTO getPromoPostById(int idUser){

        GetPromoPostBySellerDTO response = new GetPromoPostBySellerDTO();

        User user = this.userRepository.getUserById(idUser);
        if (user.isSeller() == false)
            throw new NotSellerException("Este usuario no es vendedor");
        List<Post> postsList = this.postRepository.postsByUser(idUser);

        response.setUserId(idUser);
        response.setUserName(user.getUserName());
        response.setPosts(postsList.stream().filter(p -> p.isHasPromo() == true).collect(Collectors.toList()));
        return response;
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
}
