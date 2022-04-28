package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostListDTO {
    private Long userId;
    private String userName;
    private List<PromoPostDTO> posts;

}
