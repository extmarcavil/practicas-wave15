package ar.com.mercadolibre.bootcamp.linkinitializer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link {
    private Long id;
    private String url;
    private Integer redirects;
    private Boolean invalidated;
    private String password;

    public Link() {
        this.redirects = 0;
        this.invalidated = false;
    }

    public void addRedirect() {
        this.redirects++;
    }

    public void invalidate() { this.invalidated = true; }
}
