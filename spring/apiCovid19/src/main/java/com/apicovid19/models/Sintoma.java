package com.apicovid19.models;

public class Sintoma {

    private  int Codigo;

    public  String Nombre;

    public  int NivelGravedad;

    //region getters setters

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getNivelGravedad() {
        return NivelGravedad;
    }

    public void setNivelGravedad(int nivelGravedad) {
        NivelGravedad = nivelGravedad;
    }

    //endregion
}
