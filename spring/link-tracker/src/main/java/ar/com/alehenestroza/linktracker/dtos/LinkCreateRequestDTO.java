package ar.com.alehenestroza.linktracker.dtos;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class LinkCreateRequestDTO {
    private URL url;
    private String password;
}
