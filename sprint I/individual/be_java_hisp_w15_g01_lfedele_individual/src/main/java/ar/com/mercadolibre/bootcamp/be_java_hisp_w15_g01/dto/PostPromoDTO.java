package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostPromoDTO {
    private Long userId;
    private Long postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private Integer category;
    private Float price;
    private Boolean hasPromo;
    private Float discount;
}
