package com.meli.TestCase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ResPostTestDto {

    private String desc;
    private boolean tested;
    private boolean passed;
    private int number_of_tries;
    private LocalDate lastUpdate;
    private String mensaje;

    public ResPostTestDto(){}
}
