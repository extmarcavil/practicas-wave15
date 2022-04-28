package sprint1.socialmeli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sprint1.socialmeli.dtos.*;
import sprint1.socialmeli.exceptions.InvalidParamsException;
import sprint1.socialmeli.exceptions.InvalidPostException;
import sprint1.socialmeli.exceptions.InvalidPromoPostException;
import sprint1.socialmeli.exceptions.UserNotFound;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.User;
import sprint1.socialmeli.repository.IPostRepository;
import sprint1.socialmeli.repository.ISocialMeliRepository;
import sprint1.socialmeli.utils.PostConverter;
import sprint1.socialmeli.utils.PromoPostConverter;
import sprint1.socialmeli.utils.PromoPostResponseConverter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IPostRepository postRepository;
    private final ISocialMeliRepository userRepository;
    private final PostConverter converter;

    @Override
    public Integer save(PostDTO postDTO) throws InvalidPostException {
        Post newPost = new Post(postDTO);
        return postRepository.save(newPost);
    }

    @Override
    public PostListDTO get2WeeksProductsOfFollowed(int userFollowerID, String order) {
        String sortOrder = setDefaultOrder(order);
        validateOrder(sortOrder);
        List<User> listOfFollowedUsers = getFollowedListOfAnUser(userFollowerID);
        ArrayList<Post> listOfPost = getPostsOfLast2Week(listOfFollowedUsers);
        return new PostListDTO(userFollowerID, sortDTOPosts(this.converter.createFromEntities(listOfPost), sortOrder));
    }

    @Override
    public Integer saveWithDiscount(PromoPostRequestDTO post) {
        if (!post.getHasPromo() || post.getDiscount() <= 0) {
            throw new InvalidPromoPostException("El post que se quiere crear no tiene una promocion.");
        }
        Post newPost = new PromoPostConverter().convertFromDto(post);
        return postRepository.save(newPost);
    }

    @Override
    public PromoPostCountDTO getPromoPostCount(Integer userId) {
        User user = getUser(userId);
        return preparePromoPostCountResponse(getPromoPostListDTO(user));
    }

    @Override
    public PromoPostListDTO getPromoPosts(Integer userId) {
        User user = getUser(userId);
        return getPromoPostListDTO(user);
    }

    //----------Private----------//

    private User getUser(Integer userId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new UserNotFound("No se encontro al usuario solicitado.");
        }
        return user;
    }

    private PromoPostListDTO getPromoPostListDTO(User user) {
        PromoPostListDTO res = new PromoPostListDTO();
        res.setUserId(user.getId());
        res.setUserName(user.getName());
        res.setPromoPosts(new PromoPostResponseConverter().createFromEntities(
                postRepository.getListOfPostOfUser(user.getId()).stream()
                        .filter(Post::getHasPromo)
                        .collect(Collectors.toList())
                )
        );
        return res;
    }

    private PromoPostCountDTO preparePromoPostCountResponse(PromoPostListDTO promoPostListDTO) {
        PromoPostCountDTO res = new PromoPostCountDTO();
        res.setUserId(promoPostListDTO.getUserId());
        res.setUserName(promoPostListDTO.getUserName());
        res.setPromoProductsCount(promoPostListDTO.getPromoPosts().size());
        return res;
    }

    /**
     * Obtiene una lista completa de todos los post de los usuarios seguidos (pasado por Lista), de las últimas dos semanas.
     *
     * @param listFollowed lista de usuarios seguidos por un usuario determinado.
     * @return listOfPost devuelve la lista de posts concatenada.
     */
    private ArrayList<Post> getPostsOfLast2Week(List<User> listFollowed) {
        ArrayList<Post> listOfPost = new ArrayList<>();
        for (User eachFollowedUser : listFollowed) {
            listOfPost.addAll(getUserPostOfLast2Week(eachFollowedUser.getId()));
        }
        return listOfPost;
    }

    /**
     * Obtiene la lista de usuarios seguidos por un usuario con id userFollowerID.
     *
     * @param userFollowerID identifica al usuario seguidor.
     * @return lista de usuarios seguidos.
     */
    private List<User> getFollowedListOfAnUser(int userFollowerID) {
        User userFollower = getUserFromRepositoryById(userFollowerID);
        return userFollower.getListOfFollowed();
    }

    /**
     * Retorna el usuario buscado a través de un parámetro de ID recibido.
     *
     * @param userID identificador del usuario a buscar.
     * @return user retorna el usuario en caso de que lo encuentre.
     */
    private User getUserFromRepositoryById(int userID) {
        return userRepository.findUserById(userID);
    }

    /**
     * En el caso de ser nulo, define el orden como descendente de una lista a ordenar.
     *
     * @param order tipo de ordenamiento (date_asc o date_desc).
     * @return el tipo de ordenamiento.
     */
    private String setDefaultOrder(String order) {
        return (order == null) ? "date_desc" : order;
    }

    /**
     * Ordena una Lista de DTO POST según el ordenamiento recibido por parámetro order.
     *
     * @param posts lista de PostDTO a ordenar.
     * @param order tipo de ordenamiento elegido.
     * @return la lista ordenada según el tipo de ordenamiento.
     */
    private List<PostResponseDTO> sortDTOPosts(List<PostResponseDTO> posts, String order) {
        List<PostResponseDTO> sortedPosts = posts.stream()
                .sorted(Comparator.comparing(PostResponseDTO::getDate))
                .collect(Collectors.toList());
        if (order.equals("date_desc")) {
            sortedPosts.sort(Comparator.comparing(PostResponseDTO::getDate).reversed());
        }
        return sortedPosts;
    }

    /**
     * Obtiene una lista de posteos de un usuario en particular que hayan sido realizados en las últimas dos semanas.
     *
     * @param followedIDToSearch identificador de un usuario.
     * @return la lista mencionada.
     */
    private List<Post> getUserPostOfLast2Week(int followedIDToSearch) {
        return postRepository
                .getListOfPostOfUser(followedIDToSearch)
                .stream()
                .filter(x -> x.getDate().isAfter(LocalDate.now().minusDays(14)))
                .collect(Collectors.toList());
    }

    /**
     * Comprueba que el parámetro order sea correcto.
     *
     * @param order orden a aplicar. Los parámetros admitidos son date_asc y date_desc.
     * @throws InvalidParamsException en caso de que el tipo de orden ingresado sea incorrecto.
     */
    private void validateOrder(String order) {
        if (!(order.equals("date_asc") || order.equals("date_desc"))) {
            throw new InvalidParamsException("Los parámetros ingresados son incorrectos. Este endpoint admite solo:\n" +
                    "order=date_asc\n" +
                    "order=date_desc");
        }
    }
}
