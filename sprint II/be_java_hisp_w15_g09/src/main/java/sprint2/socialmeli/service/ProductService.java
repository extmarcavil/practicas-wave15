package sprint2.socialmeli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sprint2.socialmeli.dto.post.request.RequestPostDTO;
import sprint2.socialmeli.dto.post.response.ResponsePostListDTO;
import sprint2.socialmeli.exceptions.InvalidParamsException;
import sprint2.socialmeli.exceptions.InvalidPostException;
import sprint2.socialmeli.model.Post;
import sprint2.socialmeli.model.User;
import sprint2.socialmeli.repository.IPostRepository;
import sprint2.socialmeli.repository.ISocialMeliRepository;

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

    @Override
    public Integer save(RequestPostDTO postDTO) throws InvalidPostException {
        Post newPost = new Post(postDTO);
        return postRepository.save(newPost);
    }

    @Override
    public ResponsePostListDTO get2WeeksProductsOfFollowed(int userFollowerID, String order) {
        order = checkOrderParam(order);
        System.out.println(userFollowerID);
        List<User> listOfFollowedUsers = getFollowedListOfAnUser(userFollowerID);
        ArrayList<Post> listOfPost = getPostsOfLast2Week(listOfFollowedUsers);
        return new ResponsePostListDTO(userFollowerID, sortPosts(listOfPost, order));
    }

    //----------Private----------//

    /**
     * Obtiene una lista completa de todos los post de los usuarios seguidos (pasado por Lista), de las últimas dos semanas.
     * @param listFollowed lista de usuarios seguidos por un usuario determinado.
     * @return listOfPost devuelve la lista de posts concatenada.
     */
    private ArrayList<Post> getPostsOfLast2Week(List<User> listFollowed) {
        ArrayList<Post> listOfPost = new ArrayList<>();
        for(User eachFollowedUser : listFollowed){
            listOfPost.addAll( getUserPostOfLast2Week( eachFollowedUser.getId()) );
        }
        return listOfPost;
    }

    /**
     * Obtiene la lista de usuarios seguidos por un usuario con id userFollowerID.
     * @param userFollowerID identifica al usuario seguidor.
     * @return lista de usuarios seguidos.
     */
    private List<User> getFollowedListOfAnUser(int userFollowerID) {
        User userFollower = getUserFromRepositoryById(userFollowerID);
        System.out.println(userFollowerID);
        return userFollower.getListOfFollowed();
    }

    /**
     * Retorna el usuario buscado a través de un parámetro de ID recibido.
     * @param userID identificador del usuario a buscar.
     * @return user retorna el usuario en caso de que lo encuentre.
     */
    private User getUserFromRepositoryById(int userID) {
        return userRepository.findUserById(userID);
    }

    /**
     * Ordena una Lista de POST según el ordenamiento recibido por parámetro order.
     * @param posts lista de Post a ordenar.
     * @param order tipo de ordenamiento elegido.
     * @return la lista ordenada según el tipo de ordenamiento.
     */
    private List<Post> sortPosts(List<Post> posts, String order) {
        List<Post> sortedPosts = posts.stream()
                .sorted(Comparator.comparing(Post::getDate))
                .collect(Collectors.toList());
        if (order.equals("date_desc")) {
            sortedPosts.sort(Comparator.comparing(Post::getDate).reversed());
        }
        return sortedPosts;
    }

    /**
     * Obtiene una lista de posteos de un usuario en particular que hayan sido realizados en las últimas dos semanas.
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
     * Comprueba que el parámetro order sea correcto. Si el parametro es nulo lo define
     * como name_asc por defecto
     * @param order orden a aplicar. Los parámetros admitidos son name_asc y name_desc.
     * @throws InvalidParamsException en caso de que el tipo de orden ingresado sea incorrecto.
     * @return orden chequeado
     */
    private static String checkOrderParam(String order) {
        if (order == null)
            return "date_asc";
        if (!(order.equals("date_asc") || order.equals("date_desc"))) {
            throw new InvalidParamsException("Los parámetros ingresados son incorrectos. Este endpoint admite solo:\n" +
                    "order=date_asc\n" +
                    "order=date_desc");
        }
        return order;
    }
}
