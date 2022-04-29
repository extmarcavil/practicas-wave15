package com.sprint.be_java_hisp_w15_g10.DTO.Request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint.be_java_hisp_w15_g10.DTO.DTOEntity;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromoPostCreateDTO implements DTOEntity {
    @Min(1)
    @NotNull
    private Integer user_id;
    @Valid
    @NotNull
    private ProductRequestDTO detail;
    @PastOrPresent
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate date;
    @Min(1)
    @NotNull
    @JsonAlias({"category", "category_id"})
    private Integer category_id;
    @DecimalMin("0")
    @NotNull
    private Double price;
    @NotNull
    private Boolean has_promo;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "1.0", inclusive = false)
    private Double discount;
}
