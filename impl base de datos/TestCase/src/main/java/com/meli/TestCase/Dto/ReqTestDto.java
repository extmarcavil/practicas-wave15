package com.meli.TestCase.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ReqTestDto {

    private String description;

    private boolean tested;

    private boolean passed;

    private int numberOfTries;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;
}
