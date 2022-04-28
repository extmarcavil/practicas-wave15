package com.sprint1.be_java_hisp_w15_g4.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostWithPromo extends Post{
    private boolean has_promo = true;
    private double discount;

    public PostWithPromo() {
        super();
    }
}

