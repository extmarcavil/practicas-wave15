package sprint1.socialmeli.service;

import sprint1.socialmeli.dto.PostRequestDTO;
import sprint1.socialmeli.dto.ResponsePostListDTO;

public interface IProductService {
    Integer save(PostRequestDTO post);
    ResponsePostListDTO get2WeeksProductsOfFollowed(int userFollowerID, String order);
}
