package com.practicas.deportistas.dto;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
    private String fullName;
    private String deporte;

    public PersonaDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
