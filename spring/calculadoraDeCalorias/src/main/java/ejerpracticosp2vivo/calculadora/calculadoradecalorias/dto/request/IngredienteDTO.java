package ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.request;

import lombok.Data;

@Data
public class IngredienteDTO {
    private String nombre;
    private Integer cantidad;
    private Integer calorias;

    public Double getTotal(){
        double div=cantidad*calorias/100;
        return div;
    }
}
