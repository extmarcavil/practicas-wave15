package com.sprint.be_java_hisp_w15_g10.DTO.Request;

import lombok.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

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
    @NotEmpty
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\-)(((0)[0-9])|((1)[0-2]))(\\-)\\d{4}$")
    private String date;
    @Min(1)
    private int category_id;
    @DecimalMin("0")
    private double price;
}
