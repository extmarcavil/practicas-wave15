package com.example.concesionaria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Long kilometers;
    private String descriptions;
}
