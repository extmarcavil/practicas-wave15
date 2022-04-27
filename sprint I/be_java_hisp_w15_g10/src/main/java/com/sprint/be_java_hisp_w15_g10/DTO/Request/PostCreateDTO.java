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
public class PostCreateDTO {
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
