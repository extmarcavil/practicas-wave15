package com.example.qatesters.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TestCaseDto implements Serializable {
    private final String description;
    private final Boolean tested;
    private final Boolean passed;
    private final Integer numberOfTries;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate lastUpdate;
}
