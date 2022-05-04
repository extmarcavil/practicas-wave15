package sprint2.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sprint2.socialmeli.model.Product;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotNull(message = "El  id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer productId;

    @NotBlank( message = "Que el campo no esté vacío.")
    @Size(max = 40,message =  "Longitud máxima de 40 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",message = " El campo no puede poseer caracteres especiales.")
    private String productName;

    @NotBlank( message = "Que el campo no esté vacío.")
    @Size(max = 15,message =  "Longitud máxima de 15 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",message = " El campo no puede poseer caracteres especiales.")
    private String type;

    @NotBlank( message = "Que el campo no esté vacío.")
    @Size(max = 25,message =  "Longitud máxima de 25 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",message = " El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotBlank( message = "Que el campo no esté vacío.")
    @Size(max = 15,message =  "Longitud máxima de 15 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",message = " El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80,message =  "Longitud máxima de 80 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",message = " El campo no puede poseer caracteres especiales.")
    private String notes;

    public ProductDTO(Product aProduct) {
        aProduct.mapToDTO(this);
    }
}
