package com.apideportistas.dto;

public class PersonaDeporteDTO {

    //region Variables
    private   String NombreDeportista;

    private   String Deporte;

    //endregion

    //region getters setters

    public String getNombreDeportista() {
        return NombreDeportista;
    }

    public void setNombreDeportista(String nombreDeportista) {
        NombreDeportista = nombreDeportista;
    }

    public String getDeporte() {
        return Deporte;
    }

    public void setDeporte(String deporte) {
        Deporte = deporte;
    }

    //endregion
}
