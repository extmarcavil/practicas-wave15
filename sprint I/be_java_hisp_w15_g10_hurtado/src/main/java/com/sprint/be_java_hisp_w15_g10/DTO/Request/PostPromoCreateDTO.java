package com.sprint.be_java_hisp_w15_g10.DTO.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostPromoCreateDTO extends PostDTO{
    @NotNull
    private boolean has_promo;
    @NotNull
    private double discount;
}
