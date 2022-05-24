package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.exceptions.InvalidDateException;
import com.example.be_java_hisp_w15_g05.exceptions.OrderNotValidException;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductsService implements IProductsService {

    private ModelMapper modelMapper;
    private IUserRepository userRepository;

    public ProductsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public ResCreatePostDTO createPost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);

        User user = validateUserExists(post.getUserId());
        validateDate(post.getDate());

        userRepository.createPost(user, post);

        return new ResCreatePostDTO("La publicación se ha creado con éxito");
    }

    /**
     * De un usuario se obtienen sus seguidos
     * y se recorren para obtener sus publicaciones de las últimas dos semanas
     */
    public ResPostListDTO getPostFollowed(int id, String order){
        checkSortDate(order);
        User user = validateUserExists(id);

        List<Post> listadoPosteos = new ArrayList<>();

        for( User usuario : user.getSeguidos()){
            List<Post> postAux= filterPostsInTwoWeeks( userRepository.getPostsById(usuario.getUserId()) );
            listadoPosteos.addAll(postAux);
        }
        sortListByDate(listadoPosteos, order);

        List<PostIdDTO> lista = modelMapper.map(listadoPosteos, new TypeToken<List<PostIdDTO>>() {}.getType());

        return new ResPostListDTO(id,lista);
    }

    /**
     * Verifica que la fecha sea de hoy en adelante.
     * @param date fecha para corroborar
     */
    private void validateDate(LocalDate date){
        long period = ChronoUnit.DAYS.between( date , LocalDate.now());

        if(period > 1 )
            throw new InvalidDateException("La fecha de la publicacion debe ser a partir de hoy.");
    }

    /**
     * Verificar que un id de usuario exista en el repositorio o lanza UserNotFoundException
     * @param userId id del usuario
     * @return User
     */
    private User validateUserExists(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));
    }

    /**
     * Recibe una lista de Post y la ordena seguin el parametro 'order'
     *
     * Por defecto ordena de manera asc
     *
     * @param list Lista de Post
     * @param order condición de ordenamiento
     */
    private void sortListByDate(List<Post> list, String order) {
        if(order.equals("date_desc"))
            list.sort(Comparator.comparing(Post::getDate));
        else
            list.sort(Comparator.comparing(Post::getDate).reversed());
    }

    /**
     * Verificar que sea una condición de ordenamiento valida o lanza OrderNotValidException
     * @param order condición de ordenamiento
     */
    private void checkSortDate(String order){
        if(!order.equals("date_asc") && !order.equals("date_desc") && !order.isEmpty())
            throw new OrderNotValidException("El ordenamiento " + order + " no existe.");

    }

    /**
     * Dada una fecha se verifica si esta dentro de los ultimos 14 dias.
     *
     * @param fecha fecha a corroborar
     * @return true o false segun condición
     */
    private boolean inTwoWeeksRange(LocalDate fecha){
        long differencesInDays = ChronoUnit.DAYS.between( fecha , LocalDate.now() );

        return differencesInDays < 14 && differencesInDays >= 0;
    }

    /**
     * Filtra los Post devolviendo solo aquellos que hallan sido creados en las ultimas dos semanas.
     *
     * @param posts Lista de Post
     * @return Lista de Post filtrada
     */
    private List<Post> filterPostsInTwoWeeks(List<Post> posts){
       return   posts
                .stream()
                .filter(p -> inTwoWeeksRange(p.getDate()))
                .collect(Collectors.toList());
    }
}
