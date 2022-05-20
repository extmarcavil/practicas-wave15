package com.example.segurosautos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class VehiculoPatenteYMarcaYModeloDTO {
    private String patente;
    private String marca;
    private String modelo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculoPatenteYMarcaYModeloDTO that = (VehiculoPatenteYMarcaYModeloDTO) o;
        return Objects.equals(patente, that.patente) && Objects.equals(marca, that.marca) && Objects.equals(modelo, that.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patente, marca, modelo);
    }
}
