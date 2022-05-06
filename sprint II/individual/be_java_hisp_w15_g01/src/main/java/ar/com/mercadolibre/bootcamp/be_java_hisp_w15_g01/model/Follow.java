package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Follow {
    private User follower;
    private User following;
}
