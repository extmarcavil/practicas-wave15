package sprint1.socialmeli.service;

import sprint1.socialmeli.dto.PostRequestDTO;
import sprint1.socialmeli.dto.PostResponseDTO;

import java.util.List;

public interface IProductService {
    PostResponseDTO save(PostRequestDTO post);
    List<PostResponseDTO> get2WeeksProductsOfFollowed(int userFollowerID, String order);
}
