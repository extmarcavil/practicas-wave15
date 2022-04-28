package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Favorite {
    private User user;
    private Post post;
    }
