package com.meli.cumple;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class CumpleDTO implements Serializable {
    @JsonFormat(pattern = "dd/MM/yyyy", shape= JsonFormat.Shape.STRING) // esto es para formatear
            // porque localdate puede dar problemas de errores.
    LocalDate nacimiento;

}
