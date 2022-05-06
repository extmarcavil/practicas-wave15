package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ProductDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import org.xmlunit.diff.Comparison;

import java.util.ArrayList;
import java.util.List;

public class PostListDTOFactory {

    public static PostListDTO createSimpleList(){
        Long idUser = 1L;
        List<PostDTO> listaPosts = new ArrayList<>();
        ProductDTO detail = new ProductDTO(1L, "asd", "type", "brand", "black", "");
        PostDTO p1 = new PostDTO();
        p1.setUserId(1L);
        p1.setCategory(2);
        p1.setDetail(detail);
        p1.setPrice(1F);
        p1.setDate("");
        p1.setPostId(1L);
        listaPosts.add(p1);
        PostListDTO postListDTO = new PostListDTO(1L,listaPosts);
        return postListDTO;
    }

}
