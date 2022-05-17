package com.meli.TestCase.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ReqTestCaseDto {

    private String desc;
    private boolean tested;
    private boolean passed;
    private int number_of_tries;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate lastUpdate;

    public ReqTestCaseDto(){}

}
