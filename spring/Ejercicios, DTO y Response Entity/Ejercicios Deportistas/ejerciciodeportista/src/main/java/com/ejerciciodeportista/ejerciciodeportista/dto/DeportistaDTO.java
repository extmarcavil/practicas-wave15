package com.ejerciciodeportista.ejerciciodeportista.dto;

import lombok.Data;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class DeportistaDTO implements Serializable {
    String nombre;
    String apellido;
    List<String> listaDeportesQueRealiza;
}
