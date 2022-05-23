package com.bootcamp.consecionariahql.Model.DTO.Crash;

import com.bootcamp.consecionariahql.Model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrashDTO implements Serializable {

    private LocalDate crashDate;
    private Double economicLost;
    private Vehicle vehicle;
}
