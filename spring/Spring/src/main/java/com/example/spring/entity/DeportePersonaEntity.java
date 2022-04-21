package com.example.spring.entity;

public class DeportePersonaEntity {

    private PersonaEntity persona;
    private DeporteEntity deporte;


    public DeportePersonaEntity(PersonaEntity persona, DeporteEntity deporte) {
        this.persona = persona;
        this.deporte = deporte;
    }

    public PersonaEntity getPersona() {
        return persona;
    }

    public DeporteEntity getDeporte() {
        return deporte;
    }
}
