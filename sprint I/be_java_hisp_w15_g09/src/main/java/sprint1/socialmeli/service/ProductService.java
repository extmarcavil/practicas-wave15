package sprint1.socialmeli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sprint1.socialmeli.dto.PostConverter;
import sprint1.socialmeli.dto.PostRequestDTO;
import sprint1.socialmeli.dto.PostResponseDTO;
import sprint1.socialmeli.exceptions.InvalidParamsException;
import sprint1.socialmeli.exceptions.InvalidPostException;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.User;
import sprint1.socialmeli.repository.IPostRepository;
import sprint1.socialmeli.repository.ISocialMeliRepository;

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
    public PostResponseDTO save(PostRequestDTO postDTO) throws InvalidPostException {
        Post newPost = new Post(postDTO);
        this.postRepository.save(newPost);
        return new PostResponseDTO(newPost);
    }

    @Override
    public List<PostResponseDTO> get2WeeksProductsOfFollowed(int userFollowerID, String order) {
        String sortOrder = setDefaultOrder(order);
        validateOrder(sortOrder);
        List<User> listOfFollowedUsers = getFollowedListOfAnUser(userFollowerID);
        ArrayList<Post> listOfPost = getPostsOfLast2Week(listOfFollowedUsers);
        return sortDTOPosts(this.converter.createFromEntities(listOfPost), sortOrder);
    }

    private ArrayList<Post> getPostsOfLast2Week(List<User> listFollowed) {
        ArrayList<Post> listOfPost = new ArrayList<>();
        for(User eachFollowedUser : listFollowed){
            listOfPost.addAll( getUserPostOfLast2Week( eachFollowedUser.getId()) );
        }
        return listOfPost;
    }

    private List<User> getFollowedListOfAnUser(int userFollowerID) {
        User userFollower = getUserFromRepositoryById(userFollowerID);
        List<User> listFollowed = userFollower.getListOfFollowed();
        return listFollowed;
    }

    private User getUserFromRepositoryById(int userID) {
        return userRepository.findUserById(userID);
    }

    private String setDefaultOrder(String order) {
        return (order == null) ? "date_desc" : order;
    }

    //----------Private----------//

    private List<PostResponseDTO> sortDTOPosts(List<PostResponseDTO> posts, String order) {
        List<PostResponseDTO> sortedPosts = posts.stream()
                .sorted(Comparator.comparing(PostResponseDTO::getDate))
                .collect(Collectors.toList());
        if (order.equals("date_desc")) {
            sortedPosts.sort(Comparator.comparing(PostResponseDTO::getDate).reversed());
        }
        return sortedPosts;
    }


    private List<Post> getUserPostOfLast2Week(int followedIDToSearch) {
        return postRepository
                .getListOfPostOfUser(followedIDToSearch)
                .stream()
                .filter(x -> x.getDate().isAfter(LocalDate.now().minusDays(14)))
                .collect(Collectors.toList());
    }

    private void validateOrder(String order) {
        if (!(order.equals("date_asc") || order.equals("date_desc"))) {
            throw new InvalidParamsException("Los parámetros ingresados son incorrectos. Este endpoint admite solo:\n" +
                    "order=date_asc\n" +
                    "order=date_desc");
        }
    }
}
