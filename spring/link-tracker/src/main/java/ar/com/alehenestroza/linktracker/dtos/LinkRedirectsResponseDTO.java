package ar.com.alehenestroza.linktracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LinkRedirectsResponseDTO {
    private Integer id;
    private Integer redirects;
}
