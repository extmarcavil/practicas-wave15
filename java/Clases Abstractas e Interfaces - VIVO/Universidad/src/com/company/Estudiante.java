package com.company;

public interface Estudiante extends PersonalEstudiantil{
    int idEstudiante = 0;
    String legajoEstudiante = "";

    public int getIdEstudiante();
    public String getLegajoEstudiante();
    public void setLegajoEstudiante();
}
