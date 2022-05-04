package sprint2.socialmeli.dto.post.request;

import lombok.Getter;
import lombok.Setter;
import sprint2.socialmeli.dto.ProductDTO;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class RequestPostDTO {
    @NotNull(message = "El  id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a cero")
    protected Integer userId;
    @NotBlank(message = "La fecha no puede estar vacía.")
    protected String date;
    @Valid
    protected ProductDTO detail;
    @NotNull(message = "El campo no puede estar vacío")
    protected Integer category;
    @NotNull(message = "El campo no puede estar vacío")
    @Max(value = 10000000L ,message = "    El precio máximo por producto es de 10.000.000")
    @Positive //Esto no lo aclara pero no deberia ser negativo.
    protected Double price;

    public RequestPostDTO(Integer userId, String date, ProductDTO detail, Integer category, Double price) {
        this.userId = userId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
