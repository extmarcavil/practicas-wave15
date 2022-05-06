package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Post {
    private Long postId;
    private LocalDate date;
    private Integer category;
    private Float price;
    private Product detail;
    private User user;
}
