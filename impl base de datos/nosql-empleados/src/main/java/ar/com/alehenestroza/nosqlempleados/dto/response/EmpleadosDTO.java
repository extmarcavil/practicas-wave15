package ar.com.alehenestroza.nosqlempleados.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmpleadosDTO {
    private List<EmpleadoDTO> empleados;

    public EmpleadosDTO() {
        empleados = new ArrayList<>();
    }
}
