package com.covid19.dto;

import com.covid19.model.Sintoma;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EnfermoDTO  {

    private String id;
    private String fullName;
    private int edad;
    private List<Sintoma> listSintomas;

}
