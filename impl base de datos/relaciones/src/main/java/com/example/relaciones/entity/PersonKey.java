package com.example.relaciones.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
public class PersonKey implements Serializable {
    private Integer nroDni;
    private Integer nroTramite;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonKey personKey = (PersonKey) o;
        return nroDni.equals(personKey.nroDni) && nroTramite.equals(personKey.nroTramite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroDni, nroTramite);
    }
}
