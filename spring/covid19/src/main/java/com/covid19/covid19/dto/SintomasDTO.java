package com.covid19.covid19.dto;

import com.covid19.covid19.model.Sintoma;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class SintomasDTO implements Serializable {
    List<Sintoma> sintomas;

    public SintomasDTO(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

}
