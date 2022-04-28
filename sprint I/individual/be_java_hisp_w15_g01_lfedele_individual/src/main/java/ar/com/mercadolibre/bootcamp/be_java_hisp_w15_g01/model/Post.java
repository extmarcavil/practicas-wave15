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
    private Float discount;
    private Boolean deactivated;

    public Post() {
        this.hasPromo = false;
        this.discount = 0F;
        this.deactivated = false;
    }

    public boolean isOwnedById(Long id) {
        return this.getUser().getUserId().equals(id);
    }

    public void deactivate() {
        this.setDeactivated(true);
    }

    public void activate() {
        this.setDeactivated(false);
    }
}
