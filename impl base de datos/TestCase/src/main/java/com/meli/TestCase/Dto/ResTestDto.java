package com.meli.TestCase.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResTestDto {

    private String description;

    private boolean tested;

    private boolean passed;

    private int numberOfTries;

    private LocalDate lastUpdate;
}
