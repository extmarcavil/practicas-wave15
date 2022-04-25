package com.ejerciciodeportista.ejerciciodeportista.dto;

import lombok.Data;
import lombok.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
public class DeporteDTO implements Serializable {
    String nombre;
    String nivel;
}
