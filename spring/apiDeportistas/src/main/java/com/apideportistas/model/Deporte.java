package com.apideportistas.model;
import java.io.Serializable;

public class Deporte implements Serializable {

    //region Variables
    public   String Nombre;

    public   int Nivel;

    private int IdDeporte ;
    //endregion

    //region getters setters

    public int getIdDeporte() {
        return IdDeporte;
    }

    public void setIdDeporte(int idDeporte) {
        IdDeporte = idDeporte;
    }

    //endregion
}
