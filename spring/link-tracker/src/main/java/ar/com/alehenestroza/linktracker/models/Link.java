package ar.com.alehenestroza.linktracker.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
@NoArgsConstructor
public class Link {
    private Integer linkId;
    private Integer redirects;
    private String  password;
    private URL     url;

    public Link(URL url) {
        this.url = url;
        this.password = "";
        this.redirects = 0;
    }

    public Link(URL url, String password) {
        this.url = url;
        this.password = password;
        this.redirects = 0;
    }
}
