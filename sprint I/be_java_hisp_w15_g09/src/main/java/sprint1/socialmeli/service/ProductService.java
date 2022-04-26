package sprint1.socialmeli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sprint1.socialmeli.dto.PostRequestDTO;
import sprint1.socialmeli.dto.PostResponseDTO;
import sprint1.socialmeli.exceptions.InvalidPostException;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.repository.IPostRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final IPostRepository postRepository;

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
}
