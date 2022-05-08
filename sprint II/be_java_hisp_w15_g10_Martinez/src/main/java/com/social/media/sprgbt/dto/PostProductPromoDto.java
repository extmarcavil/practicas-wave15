package com.social.media.sprgbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class PostProductPromoDto {

    private Integer userId;

    @NotNull(message = "El campo no puede estar vacio")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private String userName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer promoProductsCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PostDto> postList;
}
