package ar.com.alehenestroza.apideportistas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private String nivel;
}
