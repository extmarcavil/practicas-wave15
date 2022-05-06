package com.sprint2.be_java_hisp_w15_g4.service;

import com.sprint2.be_java_hisp_w15_g4.dto.ProductDTO;
import com.sprint2.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint2.be_java_hisp_w15_g4.dto.response.PostListDTO;
import com.sprint2.be_java_hisp_w15_g4.exception.BadOrderArgumentExcepcion;
import com.sprint2.be_java_hisp_w15_g4.exception.IDNotFoundException;
import com.sprint2.be_java_hisp_w15_g4.model.Post;
import com.sprint2.be_java_hisp_w15_g4.model.Product;
import com.sprint2.be_java_hisp_w15_g4.model.User;
import com.sprint2.be_java_hisp_w15_g4.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    IUserRepository repo;
    ModelMapper mapper = new ModelMapper();

    public ProductService(IUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public void createPost(PostDTO post) {
        User user = getUser(post.getUser_id());
        Post postToAdd = new Post();

        postToAdd.setCategory(post.getCategory());
        postToAdd.setDate(post.getDate());
        postToAdd.setDetail(productDTOToproduct(post.getDetail()));
        postToAdd.setUser_id(post.getUser_id());
        postToAdd.setPrice(post.getPrice());

        user.addPost(postToAdd);
    }

    @Override
    public PostListDTO lastTwoWeeksPosts(int userID, String order) {
        List<User> vendedoresSeguidos = repo.findUser(userID).getFollowing();

        List<Post> posts = vendedoresSeguidos.stream()
                .flatMap(v -> v.getPosts().stream())
                .filter(Post :: ultimas2Semanas)
                .collect(Collectors.toList());

        List<Post> ordenado = orderByDate(posts, order);

        List<PostDTO> lastPostsDTO = ordenado.stream()
                .map(m -> mapper.map(m, PostDTO.class))
                .collect(Collectors.toList());

        return new PostListDTO(userID, lastPostsDTO);
    }

    public Product productDTOToproduct(ProductDTO productDetail){
        Product producto = new Product();
        producto.setProduct_id(productDetail.getProduct_id());
        producto.setProduct_name(productDetail.getProduct_name());
        producto.setBrand(productDetail.getBrand());
        producto.setColor(productDetail.getColor());
        producto.setType(productDetail.getType());
        producto.setNotes(productDetail.getNotes());
        return producto;
    }

    private List<Post> orderByDate(List<Post> posts, String order) {
        if (order == null || order.equals("date_desc"))
            return posts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
        else if(order.equals("date_asc"))
            return posts.stream().sorted(Comparator.comparing(Post::getDate)).collect(Collectors.toList());
        else
            throw new BadOrderArgumentExcepcion(order);
    }

    private User getUser(int userID) {
        User user = repo.findUser(userID);
        if (user == null)
            throw new IDNotFoundException(userID);
        return user;
    }
}
