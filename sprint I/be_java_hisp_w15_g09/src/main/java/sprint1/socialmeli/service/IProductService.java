package sprint1.socialmeli.service;

import sprint1.socialmeli.dto.PostRequestDTO;
import sprint1.socialmeli.dto.PostResponseDTO;

public interface IProductService {
    PostResponseDTO save(PostRequestDTO post);
}
