package com.bootcamp.elastic.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DateDTO {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}
