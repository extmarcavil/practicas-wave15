package sprint1.socialmeli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sprint1.socialmeli.dto.PostConverter;
import sprint1.socialmeli.dto.PostRequestDTO;
import sprint1.socialmeli.dto.PostResponseDTO;
import sprint1.socialmeli.exceptions.InvalidPostException;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.User;
import sprint1.socialmeli.repository.IPostRepository;
import sprint1.socialmeli.repository.ISocialMeliRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public PostResponseDTO save(PostRequestDTO post) throws InvalidPostException {
        Post newPost = new Post(post.getUserId(), LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")), post.getDetail(), post.getCategory(), post.getPrice());
        // Validar y si no pasa, tirar BAD_REQUEST
        if (newPost.getUserId() == null ||
            newPost.getDate() == null ||
            newPost.getDetail() == null ||
            newPost.getCategory() == null ||
            newPost.getPrice() == null) {
            throw new InvalidPostException("El post contiene campos incompletos.");
        }
        this.postRepository.save(newPost);

        return new PostResponseDTO(newPost);
    }

    @Override
    public List<PostResponseDTO> get2WeeksProductsOfFollowed(int userFollowerID) {
        User userFollower = userRepository.findUserById(userFollowerID);
        List<User> listFollowed = userFollower.getListOfFollowed();

        ArrayList<Post> listOfPost = new ArrayList<>();
        for(User eachUser : listFollowed){
            int followedIDToSearch = eachUser.getId();
            listOfPost.addAll(
                    postRepository
                            .getListOfPostOfUser(followedIDToSearch)
                            .stream()
                            .filter(x->x.getDate().isAfter( LocalDate.now().minusDays(14) ))
                            .collect(Collectors.toList()));
        }
        listOfPost.sort(Comparator.comparing(Post::getDate).reversed());
        return this.converter.createFromEntities(listOfPost);
    }
}
