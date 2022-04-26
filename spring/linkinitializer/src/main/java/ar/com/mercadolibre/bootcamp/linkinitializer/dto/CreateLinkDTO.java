package ar.com.mercadolibre.bootcamp.linkinitializer.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CreateLinkDTO {
    private String link;
    private String password;
}
