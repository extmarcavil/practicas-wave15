package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    private Product detail;
    private Long userId;
    private Long postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String date;
    private ProductDTO productDTO;
    private Integer category;
    private Float price;
    //private User user;
}
