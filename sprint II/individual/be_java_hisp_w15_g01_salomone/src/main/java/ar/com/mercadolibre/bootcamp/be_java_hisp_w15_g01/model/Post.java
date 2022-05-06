package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Post {
    private Long postId;
    private LocalDate date;
    private Integer category;
    private Float price;
    private Product detail;
    private User user;
    private Boolean hasPromo;
    private Double discount;

}
