package sprint1.socialmeli.dtos.Responses;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Product;

import java.time.LocalDate;

@Getter
@Setter
public class PromoPostResponseDTO {
    private Integer postId;
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
}
