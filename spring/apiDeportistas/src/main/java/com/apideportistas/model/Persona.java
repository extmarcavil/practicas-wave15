package com.apideportistas.model;

import java.io.Serializable;

public class Persona implements Serializable {
    //region Variables
    public   String Nombre;

    public String Apellido;

    public   int Edad ;

    private  int idPersona;

    //endregion

    //region getter setters

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    //endregion
}
