package com.sprint.be_java_hisp_w15_g10.DTO.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class PostDTO {
    @Min(1)
    private int user_id;
    @Valid
    @NotNull
    private ProductRequestDTO detail;
    @PastOrPresent
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @Min(1)
    private int category_id;
    @DecimalMin("0")
    private double price;
}
