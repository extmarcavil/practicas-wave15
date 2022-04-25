package com.car.concessionaire.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
public class CarServiceEntity {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate date;
    private final String kilometers;
    private final String description;

    @Override
    public String toString() {
        return "CarServiceEntity{" +
                "date=" + date +
                ", kilometers='" + kilometers + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
