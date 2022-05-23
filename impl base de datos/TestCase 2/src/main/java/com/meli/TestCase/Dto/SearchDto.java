package com.meli.TestCase.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SearchDto {
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate last_update;
}
